package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class SweetsMonitor implements EventMonitor {
    private List<RoadUser> roadObserver = new ArrayList<>();
    @Override
    public void addRoadUser(RoadUser roadUser) {
        roadObserver.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newSweetsLocation) {
        roadObserver.forEach((observer) -> observer.handleNotification("SweetsMonitor",newSweetsLocation));

    }

    @Override
    public String getName() {
        return "Sweets Monitor";
    }
    
}
