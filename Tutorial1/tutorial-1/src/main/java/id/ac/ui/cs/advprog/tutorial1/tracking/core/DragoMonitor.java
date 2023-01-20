package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class DragoMonitor implements EventMonitor {
    private List<RoadUser> roadObserver = new ArrayList<>();

    @Override
    public void addRoadUser(RoadUser roadUser) {
        roadObserver.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newDragoLocation) {
        roadObserver.forEach((observer) -> {observer.handleNotification("DragoMonitor",newDragoLocation);});
    }

    @Override
    public String getName() {
        return "Drago Monitor";
    }
    
}
