package id.ac.ui.cs.advprog.tutorial7.core.miscapi;

// DO NOT TOUCH
public class HolidayApi {
    
    public boolean isHoliday(String day) {

        try {
            Thread.sleep(3500);
            return day.equals("Saturday") || day.equals("Sunday");
        } catch(InterruptedException e) {
            return false;
        }
        
    }
}
