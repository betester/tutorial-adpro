package id.ac.ui.cs.advprog.tutorial1.tracking.core;

public interface EventMonitor {
    
    void addRoadUser(RoadUser roadUser);
    void notifyRoadUsers(String newLocation);
    String getName();
}
