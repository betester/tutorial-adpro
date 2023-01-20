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

public class GeminiTest {

    private Class<?> geminiClass;
    private Gemini gemini;

    @BeforeEach
    public void setUp() throws Exception {
        geminiClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Gemini");
        gemini = new Gemini("Inquisitor");
    }

    @Test
    public void testGeminiIsConcreteClass() {
        assertFalse(Modifier.isAbstract(geminiClass.getModifiers()));
    }

    @Test
    public void testGeminiIsADroid() {
        Collection<Type> interfaces = Arrays.asList(geminiClass.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid")));
    }

    @Test
    public void testGeminiOverrideLiftItemMethod() throws Exception {
        Method liftItem = geminiClass.getDeclaredMethod("liftItem", String.class);

        assertEquals("java.lang.String",
            liftItem.getGenericReturnType().getTypeName());
        assertEquals(1, liftItem.getParameterCount());
        assertTrue(Modifier.isPublic(liftItem.getModifiers()));
    }

    @Test
    public void testLiftItemIsCorrectlyImplemented() {
        String result = gemini.liftItem("box");
        assertEquals("Lifting box with mechanical arms", result);
    }

    @Test
    public void testGeminiOverrideCountItemMethod() throws Exception {
        Class<?>[] countItemArgs = new Class[2];
        countItemArgs[0] = List.class;
        countItemArgs[1] = String.class;
        Method countItem = geminiClass.getDeclaredMethod("countItem", countItemArgs);

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
        String result = gemini.countItem(items, "Box");
        assertEquals("Found 1 Box", result);
    }

    @Test
    public void testGeminiOverrideUseTransporterMethod() throws Exception {
        Method useTransporter = geminiClass.getDeclaredMethod("useTransporter");

        assertEquals("java.lang.String",
            useTransporter.getGenericReturnType().getTypeName());
        assertEquals(0, useTransporter.getParameterCount());
        assertTrue(Modifier.isPublic(useTransporter.getModifiers()));
    }

    @Test
    public void testUseTransporterIsCorrectlyImplemented() {
        String result = gemini.useTransporter();
        assertEquals("Using Gemini-compatible transporter", result);
    }

    @Test
    public void testGeminiOverrideUseCraneMethod() throws Exception {
        Method useCrane = geminiClass.getDeclaredMethod("useCrane");

        assertEquals("java.lang.String",
            useCrane.getGenericReturnType().getTypeName());
        assertEquals(0, useCrane.getParameterCount());
        assertTrue(Modifier.isPublic(useCrane.getModifiers()));
    }

    @Test
    public void testUseCraneIsCorrectlyImplemented() {
        String result = gemini.useCrane();
        assertEquals("Using Gemini-compatible crane", result);
    }

    @Test
    public void testGeminiOverrideGetNameMethod() throws Exception {
        Method getName = geminiClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = gemini.getName();
        assertEquals("Inquisitor", result);
    }

    @Test
    public void testGetTypeIsCorrectlyImplemented() {
        String result = gemini.getType();
        assertEquals("Droid", result);
    }
}
