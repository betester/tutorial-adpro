package id.ac.ui.cs.advprog.tutorial1.tracking;

import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;
import id.ac.ui.cs.advprog.tutorial1.tracking.repository.RoadUserRepository;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

@Component
public class TrackingInitializer {

    @Autowired
    private EventMonitorRepository eventMonitorRepository;

    @Autowired
    private RoadUserRepository roadUserRepository;

    @PostConstruct
    public void init() {
        List<String> allowedRoutes = new ArrayList<>();
        allowedRoutes.add("Shefburg Path");
        allowedRoutes.add("Cardham Morass");
        allowedRoutes.add("Vottona Edge");

        // initialize Road Users
        RoadUser k1 = new Courier("Shinomiya Enterprises", 10, allowedRoutes);
        RoadUser k2 = new Courier("Raiden's Lightning Express", 4, allowedRoutes);
        RoadUser k3 = new Courier("Kotobuki L.td", 12, allowedRoutes);
        RoadUser d1 = new DragoHunter("Siesta's Agency", 20, allowedRoutes);

        roadUserRepository.addRoadUser(k1.getName(), k1);
        roadUserRepository.addRoadUser(k2.getName(), k2);
        roadUserRepository.addRoadUser(k3.getName(), k3);
        roadUserRepository.addRoadUser(d1.getName(), d1);


        // initialize Event Monitors
        EventMonitor dm = new DragoMonitor();
        dm.addRoadUser(k1);
        dm.addRoadUser(k2);
        dm.addRoadUser(k3);
        dm.addRoadUser(d1);

        EventMonitor sm = new SweetsMonitor();
        sm.addRoadUser(k2);

        eventMonitorRepository.addEventMonitor(dm.getName(), dm);
        eventMonitorRepository.addEventMonitor(sm.getName(), sm);


    }
}
