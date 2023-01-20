package id.ac.ui.cs.advprog.tutorial1.tracking.repository;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.RoadUser;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RoadUserRepositoryImpl implements RoadUserRepository{

    private Map<String, RoadUser> roadUsers = new HashMap<>();

    @Override
    public void addRoadUser(String name, RoadUser user) {
        roadUsers.put(name, user);
        
    }

    @Override
    public List<RoadUser> findAll() {
        return new ArrayList<>(roadUsers.values());
    }

    @Override
    public RoadUser findByName(String name) {
        return roadUsers.get(name);
    }
    
}
