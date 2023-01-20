package id.ac.ui.cs.advprog.tutorial7.service;

import id.ac.ui.cs.advprog.tutorial7.core.vaapi.VirtualAccount;
import id.ac.ui.cs.advprog.tutorial7.model.PaymentResponse;

public interface PaymentService {
    String createNewVA(int vaAmount, String bank);
    PaymentResponse pay(String va, int payAmount, String day, String time);
}
