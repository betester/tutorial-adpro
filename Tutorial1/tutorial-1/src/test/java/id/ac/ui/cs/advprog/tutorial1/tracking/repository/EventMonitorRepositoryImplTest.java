package id.ac.ui.cs.advprog.tutorial1.tracking.repository;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoMonitor;
import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventMonitorRepositoryImplTest {

    private EventMonitorRepositoryImpl eventMonitorRepository = new EventMonitorRepositoryImpl();

    @Test
    public void testWhenFindByNameCalledReturnTheEventMonitorObject() {

        eventMonitorRepository.addEventMonitor("DragoMonitor", new DragoMonitor());

        assertEquals("Drago Monitor", eventMonitorRepository.findByName("DragoMonitor").getName());

    }

    @Test
    public void testWhenFindAllReturnsArray(){
        eventMonitorRepository.addEventMonitor("DragoMonitor", new DragoMonitor());
        eventMonitorRepository.addEventMonitor("SweetsMonitor", new DragoMonitor());

        assertEquals(2, eventMonitorRepository.findAll().size());

    }
}
