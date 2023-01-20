package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public class HuntingDragoStrategy implements HuntingStrategy {

    @Override
    public void execute(List<String> allowedRoutes, String location) {
        if (!allowedRoutes.isEmpty())
            allowedRoutes.remove(0);
        if (!location.equals("None"))
            allowedRoutes.add(location);
    }
}
