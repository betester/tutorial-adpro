package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class R2Test {

    private Class<?> r2Class;
    private R2 r2;

    @BeforeEach
    public void setUp() throws Exception {
        r2Class = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.R2");
        r2 = new R2("D2");
    }

    @Test
    public void testR2IsConcreteClass() {
        assertFalse(Modifier.isAbstract(r2Class.getModifiers()));
    }

    @Test
    public void testR2IsADroid() {
        Collection<Type> interfaces = Arrays.asList(r2Class.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid")));
    }

    @Test
    public void testR2OverrideLiftItemMethod() throws Exception {
        Method liftItem = r2Class.getDeclaredMethod("liftItem", String.class);

        assertEquals("java.lang.String",
            liftItem.getGenericReturnType().getTypeName());
        assertEquals(1, liftItem.getParameterCount());
        assertTrue(Modifier.isPublic(liftItem.getModifiers()));
    }

    @Test
    public void testLiftItemIsCorrectlyImplemented() {
        String result = r2.liftItem("box");
        assertEquals("Lifting box using sockets", result);
    }

    @Test
    public void testR2OverrideCountItemMethod() throws Exception {
        Class<?>[] countItemArgs = new Class[2];
        countItemArgs[0] = List.class;
        countItemArgs[1] = String.class;
        Method countItem = r2Class.getDeclaredMethod("countItem", countItemArgs);

        assertEquals("java.lang.String",
            countItem.getGenericReturnType().getTypeName());
        assertEquals(2, countItem.getParameterCount());
        assertTrue(Modifier.isPublic(countItem.getModifiers()));
    }

    @Test
    public void testCountItemIsCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        String result = r2.countItem(items, "Box");
        assertEquals("Counted 1 Box", result);
    }

    @Test
    public void testR2OverrideUseTransporterMethod() throws Exception {
        Method useTransporter = r2Class.getDeclaredMethod("useTransporter");

        assertEquals("java.lang.String",
            useTransporter.getGenericReturnType().getTypeName());
        assertEquals(0, useTransporter.getParameterCount());
        assertTrue(Modifier.isPublic(useTransporter.getModifiers()));
    }

    @Test
    public void testUseTransporterIsCorrectlyImplemented() {
        String result = r2.useTransporter();
        assertEquals("Using R2-compatible transporter", result);
    }

    @Test
    public void testR2OverrideUseCraneMethod() throws Exception {
        Method useCrane = r2Class.getDeclaredMethod("useCrane");

        assertEquals("java.lang.String",
            useCrane.getGenericReturnType().getTypeName());
        assertEquals(0, useCrane.getParameterCount());
        assertTrue(Modifier.isPublic(useCrane.getModifiers()));
    }

    @Test
    public void testUseCraneIsCorrectlyImplemented() {
        String result = r2.useCrane();
        assertEquals("Using R2-compatible crane", result);
    }

    @Test
    public void testR2OverrideGetNameMethod() throws Exception {
        Method getName = r2Class.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = r2.getName();
        assertEquals("D2", result);
    }

    @Test
    public void testGetTypeIsCorrectlyImplemented() {
        String result = r2.getType();
        assertEquals("Droid", result);
    }
}
