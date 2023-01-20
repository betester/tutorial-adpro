package id.ac.ui.cs.advprog.tutorial1.tracking.repository;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.EventMonitor;
import java.util.List;


public interface EventMonitorRepository {
    
    void addEventMonitor(String name, EventMonitor user);
    List<EventMonitor> findAll();
    EventMonitor findByName(String name);

}
