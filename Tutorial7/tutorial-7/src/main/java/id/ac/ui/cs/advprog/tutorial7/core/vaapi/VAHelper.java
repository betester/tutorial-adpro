package id.ac.ui.cs.advprog.tutorial7.core.vaapi;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import id.ac.ui.cs.advprog.tutorial7.core.bankapi.BankApi;
import id.ac.ui.cs.advprog.tutorial7.core.bankapi.GinkoApi;
import id.ac.ui.cs.advprog.tutorial7.core.bankapi.GoblinBankApi;

// DO NOT TOUCH
public class VAHelper {

    Map<String, VirtualAccount> vas = new HashMap<>();
    
    private static String generateCode() {
        //Taken from: https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public BankApi getBankByVA(String va) {

        try {
            Thread.sleep(1800);
            VirtualAccount vaObj = vas.get(va);
            if(vaObj == null) throw new NoSuchElementException();

            String bankName = vaObj.getBank();
            if(bankName.equals("Ginko")) return new GinkoApi();
            else return new GoblinBankApi();

        } catch(InterruptedException e) {
            return null;
        } 
    }

    public int getVAAmount(String va) {

        try {

            Thread.sleep(2000);
            VirtualAccount vaObj = vas.get(va);
            if(vaObj == null) throw new NoSuchElementException();
            return vaObj.getVaAmount();
        } catch(InterruptedException e) {
            return -1;
        } 
    }

    private boolean isVaPayed(String va) {

        VirtualAccount vaObj = vas.get(va);
        return vaObj.getIsPayed();
    }

    // validates and log if the payment amount is sufficient
    public String validatePayment(String va, int vaAmount, int payAmount) {
        try {
            Thread.sleep(1969);
            if(isVaPayed(va)) return "VA already payed";
            if(payAmount < vaAmount) return "Cash insufficient to pay VA";

            return "";
        } catch(InterruptedException e) {
            return "";
        }
    }

    // creates new VA
    public String createNewVA(int payAmount, String bank) {
        String code = generateCode();
        VirtualAccount newVA = new VirtualAccount(code, payAmount, bank);
        vas.put(code, newVA);
        return code;
    }

    // logs and update if the VA payment is successfull
    public void logVAPayment(String va, boolean status) {
        try {
            Thread.sleep(3000);
            if(status) {
                vas.get(va).setIsPayed(true);
                System.out.println("Virtual Account " + va + " is payed successfully");
            } else {
                System.out.println("Virtual Account " + va + " is failed");
            }
        } catch(InterruptedException e) {
        }
    }
}
