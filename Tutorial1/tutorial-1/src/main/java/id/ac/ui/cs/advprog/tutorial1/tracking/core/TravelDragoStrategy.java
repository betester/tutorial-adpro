package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public class TravelDragoStrategy implements TravelStrategy {

    @Override
    public String execute(String dragoCurrentLocation,String sweetCurrentLocation,List<String> allowedRoutes,String location) {
        boolean add = (
                dragoCurrentLocation != null &&
                !allowedRoutes.contains(dragoCurrentLocation) &&
                allowedRoutes.add(dragoCurrentLocation));
        boolean remove = !location.equals(sweetCurrentLocation) && allowedRoutes.remove(location);
        return location;
    }
}
