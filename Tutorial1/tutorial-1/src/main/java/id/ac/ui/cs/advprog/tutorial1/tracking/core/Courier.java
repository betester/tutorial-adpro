package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class Courier implements RoadUser {

    private String name;
    private int speed;
    private List<String> allowedRoutes;
    private TravelStrategy strategy;
    private String sweetCurrentLocation;
    private String dragoCurrentLocation;

    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public Courier(String name, int speed, List<String> allowedRoutes) {
        
        this.name = name;
        this.speed = speed;
        this.allowedRoutes = new ArrayList<>(allowedRoutes);
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        if (notificationFrom.equals("DragoMonitor")) {
            strategy = new TravelDragoStrategy();
            dragoCurrentLocation = strategy.execute(dragoCurrentLocation,sweetCurrentLocation,allowedRoutes,location);

        if (dragoCurrentLocation.equals("None")) {
            dragoCurrentLocation = null;
            }
        }
        else {
            strategy = new TravelSweetStrategy();
            sweetCurrentLocation = strategy.execute(dragoCurrentLocation,sweetCurrentLocation,allowedRoutes, location);
            if (sweetCurrentLocation.equals("None")) {
                sweetCurrentLocation = null;
            }
        }
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public List<String> getAllowedRoutes() {
        return allowedRoutes;
    }
    @Override
    public String getName() {
        return name;
    }
    
}
