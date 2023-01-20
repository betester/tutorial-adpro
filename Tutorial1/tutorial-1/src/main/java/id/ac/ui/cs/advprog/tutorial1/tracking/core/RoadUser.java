package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public interface RoadUser {
    void handleNotification(String notificationFrom, String location);
    String getName();
    public List<String> getAllowedRoutes();
    int getSpeed();
}
