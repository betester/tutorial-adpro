package id.ac.ui.cs.advprog.tutorial7.core.async;

import id.ac.ui.cs.advprog.tutorial7.core.bankapi.BankApi;

import java.util.function.Supplier;

public class BankApiPayAsync implements Supplier<Boolean> {

    private final BankApi bankApi;
    private final int payAmount;

    public BankApiPayAsync(BankApi bankApi, int payAmount) {
        this.bankApi = bankApi;
        this.payAmount = payAmount;
    }

    @Override
    public Boolean get() {
        return bankApi.pay(payAmount);
    }
}
