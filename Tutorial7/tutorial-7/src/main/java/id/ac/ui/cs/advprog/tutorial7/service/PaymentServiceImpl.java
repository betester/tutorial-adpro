package id.ac.ui.cs.advprog.tutorial7.service;

import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import id.ac.ui.cs.advprog.tutorial7.core.async.*;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.tutorial7.core.bankapi.BankApi;
import id.ac.ui.cs.advprog.tutorial7.core.miscapi.HolidayApi;
import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VAHelper;
import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VirtualAccount;
import id.ac.ui.cs.advprog.tutorial7.model.PaymentResponse;

@Service
public class PaymentServiceImpl implements PaymentService{

    HolidayApi holidayApi = new HolidayApi();
    VAHelper vaHelper = new VAHelper();

    @Override
    public String createNewVA(int vaAmount, String bank) {
        
        String va = vaHelper.createNewVA(vaAmount, bank);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            return null;
        }
    
        return va;
    }


    @Override
    public PaymentResponse pay(String va, int payAmount, String day, String time) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletableFuture<Boolean> isHolidayFuture = CompletableFuture.supplyAsync(new HolidayApiAsync(holidayApi,day),executorService);
        CompletableFuture<Integer> vaAmountFuture = CompletableFuture.supplyAsync(new VAAmountHelperAsync(vaHelper,va),executorService);
        CompletableFuture<BankApi> bankApiFuture = CompletableFuture.supplyAsync(new VAGetBankAsync(vaHelper,va),executorService);

        CompletableFuture<Object> futureResponse = CompletableFuture.allOf(vaAmountFuture,bankApiFuture).thenApply(
                (iterator) -> {
                    Integer vaAmount = vaAmountFuture.join();
                    BankApi bankApi = bankApiFuture.join();

                    if (bankApi == null || vaAmount == null) {
                        return  new PaymentResponse(0, "VA number not found");
                    }

                    CompletableFuture<Boolean> isBankCloseFuture = CompletableFuture
                            .supplyAsync(new BankCloseAsync(bankApi,time,payAmount),executorService);

                    CompletableFuture<String> validatePaymentFuture = CompletableFuture
                            .supplyAsync(new VaValidatePaymentAsync(vaHelper,va,vaAmount,payAmount),executorService);

                    CompletableFuture<Boolean> paymentStatusFuture = CompletableFuture
                            .supplyAsync(new BankApiPayAsync(bankApi,payAmount),executorService);


                    return CompletableFuture.allOf(isBankCloseFuture,validatePaymentFuture,paymentStatusFuture)
                            .thenApply((iterator2) -> {
                                boolean isBankClose = isBankCloseFuture.join();
                                String validatePayment = validatePaymentFuture.join();
                                boolean paymentStatus = paymentStatusFuture.join();

                                if (isBankClose) {
                                    return new PaymentResponse(0, "Bank already closed, please try again tomorrow");
                                }

                                if (!validatePayment.equals("")) {
                                    return new PaymentResponse(0, validatePayment);
                                }

                                if (!paymentStatus) {
                                    return new PaymentResponse(0, "Payment unsuccessfull, please try again");
                                }
                                return new PaymentResponse(1, "Payment successfull");
                            }).join();

                }
        );



        PaymentResponse paymentResponse = (PaymentResponse) isHolidayFuture.thenApply(response -> {
            if (response) {
                return new PaymentResponse(0, "Cannot pay on holidays");
            }
            return futureResponse.join();
        }).join();

        if (paymentResponse.message.equals("Payment successfull")) {
            CompletableFuture.runAsync(new VaLogPaymentAsync(vaHelper, true, va))
                    .thenRun(executorService::shutdown);
        }
        else {
            CompletableFuture.runAsync(new VaLogPaymentAsync(vaHelper, false, va))
                    .thenRun(executorService::shutdown);
        }

        return paymentResponse;
    }
}
