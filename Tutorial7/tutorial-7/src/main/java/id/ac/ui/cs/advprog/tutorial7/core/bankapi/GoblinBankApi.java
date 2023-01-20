package id.ac.ui.cs.advprog.tutorial7.core.bankapi;

import java.util.Random;

// DO NOT TOUCH
public class GoblinBankApi implements BankApi {

    Random rng = new Random();

    @Override
    public boolean isBankClosed(String time, int payAmount) {
        
        try {
            Thread.sleep(1969);

            if(payAmount > 1000000) return time.compareTo("14:00") > 0;
            else return time.compareTo("16:00") > 0;
        } catch(InterruptedException e) {
            return false;
        }
    }

    @Override
    public boolean pay(int payAmount) {
        

        try {
            Thread.sleep(1000);
            
            boolean successfull = rng.nextInt(2) == 0;
            if(successfull) {
                System.out.println("GoblinBank Virtual Account of " + payAmount + " is payed");
                return true;
            } else {
                System.out.println("GoblinBank Virtual Account of " + payAmount + " is payed unsuccessfully");
                return false;
            }

        } catch(InterruptedException e) {
            return false;
        }
    }
    
}
