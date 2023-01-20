package id.ac.ui.cs.advprog.tutorial7.core.bankapi;

// DO NOT TOUCH
public class GinkoApi implements BankApi {

    @Override
    public boolean isBankClosed(String time, int payAmount) {

        try {

            Thread.sleep(1969);
            return (time.compareTo("16:00") > 0);
        } catch(InterruptedException e) {
            return false;
        }
       
    }

    @Override
    public boolean pay(int payAmount) {
        try {

            Thread.sleep(1000);
            System.out.println("Ginko Virtual Account of " + payAmount + " is payed");
            return true;
        } catch(InterruptedException e) {
            return false;
        }
    }
    
}
