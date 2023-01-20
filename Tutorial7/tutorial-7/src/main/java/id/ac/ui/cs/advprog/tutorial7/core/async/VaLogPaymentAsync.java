package id.ac.ui.cs.advprog.tutorial7.core.async;

import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VAHelper;


public class VaLogPaymentAsync implements Runnable {
    private final VAHelper vaHelper;
    private final boolean paymentStatus;
    private final String va;

    public VaLogPaymentAsync(VAHelper vaHelper, boolean paymentStatus, String va) {
        this.vaHelper = vaHelper;
        this.paymentStatus = paymentStatus;
        this.va = va;
    }


    @Override
    public void run() {
        vaHelper.logVAPayment(va,paymentStatus);
    }
}
