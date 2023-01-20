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

public class T800Test {

    private Class<?> t800Class;
    private T800 t800;

    @BeforeEach
    public void setUp() throws Exception {
        t800Class = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.T800");
        t800 = new T800("Terminator");
    }

    @Test
    public void testT800IsConcreteClass() {
        assertFalse(Modifier.isAbstract(t800Class.getModifiers()));
    }

    @Test
    public void testT800IsADroid() {
        Collection<Type> interfaces = Arrays.asList(t800Class.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid")));
    }

    @Test
    public void testT800OverrideLiftItemMethod() throws Exception {
        Method liftItem = t800Class.getDeclaredMethod("liftItem", String.class);

        assertEquals("java.lang.String",
            liftItem.getGenericReturnType().getTypeName());
        assertEquals(1, liftItem.getParameterCount());
        assertTrue(Modifier.isPublic(liftItem.getModifiers()));
    }

    @Test
    public void testLiftItemIsCorrectlyImplemented() {
        String result = t800.liftItem("box");
        assertEquals("Lifting box using mechanical arms", result);
    }

    @Test
    public void testT800OverrideCountItemMethod() throws Exception {
        Class<?>[] countItemArgs = new Class[2];
        countItemArgs[0] = List.class;
        countItemArgs[1] = String.class;
        Method countItem = t800Class.getDeclaredMethod("countItem", countItemArgs);

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
        String result = t800.countItem(items, "Box");
        assertEquals("Counted 1 Box", result);
    }

    @Test
    public void testT800OverrideUseTransporterMethod() throws Exception {
        Method useTransporter = t800Class.getDeclaredMethod("useTransporter");

        assertEquals("java.lang.String",
            useTransporter.getGenericReturnType().getTypeName());
        assertEquals(0, useTransporter.getParameterCount());
        assertTrue(Modifier.isPublic(useTransporter.getModifiers()));
    }

    @Test
    public void testUseTransporterIsCorrectlyImplemented() {
        String result = t800.useTransporter();
        assertEquals("Using any available transporter", result);
    }

    @Test
    public void testT800OverrideUseCraneMethod() throws Exception {
        Method useCrane = t800Class.getDeclaredMethod("useCrane");

        assertEquals("java.lang.String",
            useCrane.getGenericReturnType().getTypeName());
        assertEquals(0, useCrane.getParameterCount());
        assertTrue(Modifier.isPublic(useCrane.getModifiers()));
    }

    @Test
    public void testUseCraneIsCorrectlyImplemented() {
        String result = t800.useCrane();
        assertEquals("Using any available crane", result);
    }

    @Test
    public void testT800OverrideGetNameMethod() throws Exception {
        Method getName = t800Class.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = t800.getName();
        assertEquals("Terminator", result);
    }

    @Test
    public void testGetTypeIsCorrectlyImplemented() {
        String result = t800.getType();
        assertEquals("Droid", result);
    }
}
