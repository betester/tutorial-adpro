package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import id.ac.ui.cs.advprog.tutorial1.tracking.core.Courier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourierTest {

    private Courier courier;

    private ArrayList<String> routes;

    private Class<?> courierClass;

    @BeforeEach
    public void setUp() throws Exception{
        routes = new ArrayList<>();
        routes.add("Sangonomiya");
        routes.add("Jakarta");
        routes.add("Shibuya");

        courierClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.tracking.core.Courier");
        courier = Mockito.spy(new Courier("Shinomiya Enterprises", 10, routes));
    }

    @Test
    public void testCourierGetSpeedMethod() throws Exception{
        Method getSpeed = courierClass.getDeclaredMethod("getSpeed");

        assertTrue(Modifier.isPublic(getSpeed.getModifiers()));
        assertEquals(0, getSpeed.getParameterCount());
        assertEquals("int", getSpeed.getGenericReturnType().getTypeName());
        assertEquals(10, courier.getSpeed());

    }

    @Test
    public void testCourierGetNameMethod() throws Exception{
        Method getName = courierClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
        assertEquals("Shinomiya Enterprises", courier.getName());

    }

}
