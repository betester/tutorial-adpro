package id.ac.ui.cs.advprog.tutorial7.core.async;

import id.ac.ui.cs.advprog.tutorial7.core.bankapi.BankApi;

import java.util.function.Supplier;

public class BankCloseAsync implements Supplier<Boolean> {

    private final BankApi bankApi;
    private final String time;
    private final int payAmount;

    public BankCloseAsync(BankApi bankApi, String time, int payAmount) {
        this.bankApi = bankApi;
        this.time = time;
        this.payAmount = payAmount;
    }


    @Override
    public Boolean get() {
        return bankApi.isBankClosed(time,payAmount);
    }
}
