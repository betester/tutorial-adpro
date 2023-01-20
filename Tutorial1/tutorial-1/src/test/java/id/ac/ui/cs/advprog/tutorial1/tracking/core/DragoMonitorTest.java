package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.Courier;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoHunter;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoMonitor;
import id.ac.ui.cs.advprog.tutorial1.tracking.core.RoadUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DragoMonitorTest {

    private DragoMonitor dragoMonitor;

    private Class<?> dragoMonitorClass;

    private ArrayList<String> routes;

    @BeforeEach
    public void setUp() throws Exception{
        routes = new ArrayList<>();
        routes.add("Sangonomiya");
        routes.add("Jakarta");
        routes.add("Shibuya");

        dragoMonitorClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoMonitor");
        dragoMonitor = Mockito.spy(new DragoMonitor());
    }

    @Test
    public void testDragoHunterGetNameMethod() throws Exception{
        Method getName = dragoMonitorClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
        assertEquals("Drago Monitor", dragoMonitor.getName());

    }

    @Test
    public void testAddRoadUserMethod(){
        RoadUser newCourier = new Courier("Green Day Courier", 10, routes);
        doNothing().when(dragoMonitor).addRoadUser(newCourier);
        dragoMonitor.addRoadUser(newCourier);

        verify(dragoMonitor, times(1))
                .addRoadUser(newCourier);

    }

    @Test
    public void testDragoMonitorNotifyRoadUsersMethod(){
        RoadUser newCourierA = Mockito.spy(new Courier("Green Day Courier", 10, routes));
        RoadUser newCourierB = Mockito.spy(new Courier("Coldplay Courier", 20, routes));
        RoadUser newHunterA = Mockito.spy(new DragoHunter("New World Ltd.", 50, routes));

        doNothing().when(newCourierA).handleNotification("DragoMonitor", "Jakarta");
        doNothing().when(newCourierB).handleNotification("DragoMonitor", "Jakarta");
        doNothing().when(newHunterA).handleNotification("DragoMonitor", "Jakarta");

        dragoMonitor.addRoadUser(newCourierA);
        dragoMonitor.addRoadUser(newCourierB);
        dragoMonitor.addRoadUser(newHunterA);

        dragoMonitor.notifyRoadUsers("Jakarta");
        verify(newCourierA, times(1))
                .handleNotification("DragoMonitor", "Jakarta");
        verify(newCourierB, times(1))
                .handleNotification("DragoMonitor", "Jakarta");
        verify(newHunterA, times(1))
                .handleNotification("DragoMonitor", "Jakarta");
    }
}
