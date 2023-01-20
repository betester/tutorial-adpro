package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoHunter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DragoHunterTest {

    private DragoHunter dragoHunter;

    private ArrayList<String> routes;

    private Class<?> dragoHunterClass;

    @BeforeEach
    public void setUp() throws Exception{
        routes = new ArrayList<>();
        routes.add("Sangonomiya");
        routes.add("Jakarta");
        routes.add("Shibuya");

        dragoHunterClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.tracking.core.DragoHunter");
        dragoHunter = Mockito.spy(new DragoHunter("Siesta's Agency", 20, routes));
    }

    @Test
    public void testDragoHunterGetSpeedMethod() throws Exception{
        Method getSpeed = dragoHunterClass.getDeclaredMethod("getSpeed");

        assertTrue(Modifier.isPublic(getSpeed.getModifiers()));
        assertEquals(0, getSpeed.getParameterCount());
        assertEquals("int", getSpeed.getGenericReturnType().getTypeName());
        assertEquals(20, dragoHunter.getSpeed());

    }

    @Test
    public void testDragoHunterGetNameMethod() throws Exception{
        Method getName = dragoHunterClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
        assertEquals("Siesta's Agency", dragoHunter.getName());

    }
}
