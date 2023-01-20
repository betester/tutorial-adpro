package id.ac.ui.cs.advprog.tutorial1.tracking.service;

import java.util.List;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.RoadUser;

public interface TrackingService {
    List<RoadUser> getRoadUsers();
    void handleNewEventLocation(String eventName, String location);
}
