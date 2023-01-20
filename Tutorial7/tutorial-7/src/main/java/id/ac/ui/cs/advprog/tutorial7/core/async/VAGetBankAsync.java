package id.ac.ui.cs.advprog.tutorial7.core.async;

import id.ac.ui.cs.advprog.tutorial7.core.bankapi.BankApi;
import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VAHelper;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class VAGetBankAsync implements Supplier<BankApi> {

    private final VAHelper helper;
    private final String bank;

    public VAGetBankAsync(VAHelper helper, String bank) {
        this.helper = helper;
        this.bank = bank;
    }

    @Override
    public BankApi get() {
        try {
            return helper.getBankByVA(bank);
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }
}
