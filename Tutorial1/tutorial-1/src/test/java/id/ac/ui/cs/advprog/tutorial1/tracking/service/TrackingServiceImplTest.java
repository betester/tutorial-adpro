package id.ac.ui.cs.advprog.tutorial1.tracking.service;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.*;
import id.ac.ui.cs.advprog.tutorial1.tracking.repository.EventMonitorRepository;
import id.ac.ui.cs.advprog.tutorial1.tracking.repository.RoadUserRepository;
import id.ac.ui.cs.advprog.tutorial1.tracking.service.TrackingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrackingServiceImplTest {

    @Mock
    private RoadUserRepository roadUserRepository;

    @Mock
    private EventMonitorRepository eventMonitorRepository;

    @InjectMocks
    TrackingServiceImpl trackingService;

    @Test
    public void testWhenGetRoadUsersCalledThenReturnList(){
        when(roadUserRepository.findAll()).thenReturn(new ArrayList<>());
        List<RoadUser> data = trackingService.getRoadUsers();
        assertEquals(0, data.size());
    }

    @Test
    public void testWhenHandleEventLocationCalled() {
        DragoMonitor dragoMonitorTest = Mockito.spy(new DragoMonitor());
        SweetsMonitor sweetsMonitorTest = Mockito.spy(new SweetsMonitor());

        dragoMonitorTest.addRoadUser(new Courier("A", 20, new ArrayList<>()));
        dragoMonitorTest.addRoadUser(new DragoHunter("B", 30, new ArrayList<>()));
        sweetsMonitorTest.addRoadUser(new DragoHunter("C", 21, new ArrayList<>()));

        when(eventMonitorRepository.findByName("Drago Monitor")).thenReturn(dragoMonitorTest);

        trackingService.handleNewEventLocation("Drago Monitor", "Shefburg Path");
        verify(dragoMonitorTest, times(1)).notifyRoadUsers("Shefburg Path");
        verify(sweetsMonitorTest, times(0)).notifyRoadUsers("Shefburg Path");
    }
}
