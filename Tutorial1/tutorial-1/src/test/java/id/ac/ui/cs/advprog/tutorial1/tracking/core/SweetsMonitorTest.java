package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.Courier;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoHunter;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.RoadUser;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.SweetsMonitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SweetsMonitorTest {
    
    private SweetsMonitor sweetsMonitor;

    private Class<?> sweetsMonitorClass;

    private ArrayList<String> routes;

    @BeforeEach
    public void setUp() throws Exception{
        routes = new ArrayList<>();
        routes.add("Sangonomiya");
        routes.add("Jakarta");
        routes.add("Shibuya");

        sweetsMonitorClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.tracking.core.SweetsMonitor");
        sweetsMonitor = Mockito.spy(new SweetsMonitor());
    }

    @Test
    public void testSweetsHunterGetNameMethod() throws Exception{
        Method getName = sweetsMonitorClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
        assertEquals("Sweets Monitor", sweetsMonitor.getName());

    }

    @Test
    public void testAddRoadUserMethod(){
        RoadUser newCourier = new Courier("Green Day Courier", 10, routes);
        doNothing().when(sweetsMonitor).addRoadUser(newCourier);
        sweetsMonitor.addRoadUser(newCourier);

        verify(sweetsMonitor, times(1))
                .addRoadUser(newCourier);
    }

    @Test
    public void testSweetsMonitorNotifyRoadUsersMethod(){

        RoadUser newCourierA = Mockito.spy(new Courier("Green Day Courier", 10, routes));
        RoadUser newCourierB = Mockito.spy(new Courier("Coldplay Courier", 20, routes));
        RoadUser newHunterA = Mockito.spy(new DragoHunter("New World Ltd.", 50, routes));

        doNothing().when(newCourierA).handleNotification("SweetsMonitor", "Jakarta");
        doNothing().when(newCourierB).handleNotification("SweetsMonitor", "Jakarta");
        doNothing().when(newHunterA).handleNotification("SweetsMonitor", "Jakarta");

        sweetsMonitor.addRoadUser(newCourierA);
        sweetsMonitor.addRoadUser(newCourierB);
        sweetsMonitor.addRoadUser(newHunterA);

        sweetsMonitor.notifyRoadUsers("Jakarta");
        verify(newCourierA, times(1))
                .handleNotification("SweetsMonitor", "Jakarta");
        verify(newCourierB, times(1))
                .handleNotification("SweetsMonitor", "Jakarta");
        verify(newHunterA, times(1))
                .handleNotification("SweetsMonitor", "Jakarta");

    }

}
