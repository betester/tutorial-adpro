package id.ac.ui.cs.advprog.tutorial1.tracking.repository;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.Courier;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoMonitor;
import id.ac.ui.cs.advprog.tutorial1.tracking.repository.RoadUserRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoadUserRepositoryImplTest {
    private RoadUserRepositoryImpl roadUserRepository = new RoadUserRepositoryImpl();

    @Test
    public void testWhenFindByNameCalledReturnTheRoadUserObject() {

        roadUserRepository.addRoadUser("TestCourier", new Courier("Test Courier",
                20, new ArrayList<String>()));

        assertEquals("Test Courier", roadUserRepository.findByName("TestCourier").getName());

    }

    @Test
    public void testWhenFindAllReturnsArray(){
        roadUserRepository.addRoadUser("TestCourier", new Courier("Test Courier",
                20, new ArrayList<String>()));
        roadUserRepository.addRoadUser("BlameCourier", new Courier("Blame Courier",
                30, new ArrayList<String>()));

        assertEquals(2, roadUserRepository.findAll().size());

    }
}
