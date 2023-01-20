package id.ac.ui.cs.advprog.tutorial7.core.async;

import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VAHelper;

import java.util.function.Supplier;

public class VaValidatePaymentAsync implements Supplier<String> {
    private final VAHelper helper;
//    va, vaAmount, payAmount
    private final String va;
    private final int vaAmount;
    private final int payAmount;


    public VaValidatePaymentAsync(VAHelper helper, String va, int vaAmount, int payAmount) {
        this.helper = helper;
        this.va = va;
        this.vaAmount = vaAmount;
        this.payAmount = payAmount;
    }

    @Override
    public String get() {
        return helper.validatePayment(va,vaAmount,payAmount);
    }
}
