package id.ac.ui.cs.advprog.tutorial1.tracking.repository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.EventMonitor;

@Repository
public class EventMonitorRepositoryImpl implements EventMonitorRepository {

    private Map<String, EventMonitor> eventMonitors = new HashMap<>();

    @Override
    public void addEventMonitor(String name, EventMonitor user) {
        eventMonitors.put(name, user);
        
    }

    @Override
    public List<EventMonitor> findAll() {
        return new ArrayList<>(eventMonitors.values());
    }

    @Override
    public EventMonitor findByName(String name) {
        return eventMonitors.get(name);
    }
    
}
