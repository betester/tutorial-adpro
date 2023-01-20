package id.ac.ui.cs.advprog.tutorial1.tracking.core;
import java.util.ArrayList;
import java.util.List;

public class DragoHunter implements RoadUser {

    private String name;
    private int speed;
    private List<String> allowedRoutes;
    private HuntingStrategy strategy;
    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public DragoHunter(String name, int speed, List<String> allowedRoutes) {
        this.name = name;
        this.speed = speed;
        this.allowedRoutes = new ArrayList<>();
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        if (notificationFrom.equals("DragoMonitor")) {
            strategy = new HuntingDragoStrategy();
            strategy.execute(allowedRoutes,location);
        }
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<String> getAllowedRoutes() {
        return allowedRoutes;
    }
}
