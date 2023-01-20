package id.ac.ui.cs.advprog.tutorial1.tracking.repository;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.RoadUser;
import java.util.List;

public interface RoadUserRepository {
    
    void addRoadUser(String name, RoadUser user);
    List<RoadUser> findAll();
    RoadUser findByName(String name);
}
