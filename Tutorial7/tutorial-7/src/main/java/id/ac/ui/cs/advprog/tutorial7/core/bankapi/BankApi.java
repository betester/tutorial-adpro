package id.ac.ui.cs.advprog.tutorial7.core.bankapi;

public interface BankApi {
    boolean isBankClosed(String time, int payAmount);
    boolean pay(int payAmount);
}
