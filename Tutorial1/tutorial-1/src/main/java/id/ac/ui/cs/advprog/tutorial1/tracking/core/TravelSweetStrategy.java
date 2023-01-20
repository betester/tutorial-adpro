package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public class TravelSweetStrategy implements TravelStrategy {

    @Override
    public String execute(String dragoCurrentLocation, String sweetCurrentLocation, List<String> allowedRoutes,String location) {
        if (dragoCurrentLocation != null && dragoCurrentLocation.equals(sweetCurrentLocation)) {
            allowedRoutes.remove(sweetCurrentLocation);
        }
        boolean add =  !location.equals("None") && !allowedRoutes.contains(location) && allowedRoutes.add(location);
        return location;
    }
}
