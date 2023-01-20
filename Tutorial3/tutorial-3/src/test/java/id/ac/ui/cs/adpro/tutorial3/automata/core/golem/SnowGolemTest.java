package id.ac.ui.cs.adpro.tutorial3.automata.core.golem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SnowGolemTest {

    private Class<?> snowGolemClass;
    private SnowGolem snowGolem;

    @BeforeEach
    public void setUp() throws Exception {
        snowGolemClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.golem.SnowGolem");
        snowGolem = new SnowGolem("Joergen");
    }

    @Test
    public void testSnowGolemIsConcreteClass() {
        assertFalse(Modifier.isAbstract(snowGolemClass.getModifiers()));
    }

    @Test
    public void testSnowGolemIsAGolem() {
        Collection<Type> interfaces = Arrays.asList(snowGolemClass.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem")));
    }

    @Test
    public void testSnowGolemOverrideLiftItemMethod() throws Exception {
        Method liftItem = snowGolemClass.getDeclaredMethod("liftItem", String.class);

        assertEquals("java.lang.String",
            liftItem.getGenericReturnType().getTypeName());
        assertEquals(1, liftItem.getParameterCount());
        assertTrue(Modifier.isPublic(liftItem.getModifiers()));
    }

    @Test
    public void testLiftItemIsCorrectlyImplemented() {
        String result = snowGolem.liftItem("box");
        assertEquals("Lifting box with two hands", result);
    }

    @Test
    public void testSnowGolemHasIsItemMethod() throws Exception {
        Class<?>[] countItemArgs = new Class[2];
        countItemArgs[0] = String.class;
        countItemArgs[1] = String.class;
        Method countItem = snowGolemClass.getDeclaredMethod("isItem", countItemArgs);

        assertEquals("java.lang.String",
            countItem.getGenericReturnType().getTypeName());
        assertEquals(2, countItem.getParameterCount());
        assertTrue(Modifier.isPublic(countItem.getModifiers()));
    }

    @Test
    public void testisItemIsCorrectlyImplemented() {
        String result = snowGolem.isItem("Homa", "Box");
        String expected = "item Homa is not Box";
        assertEquals(expected, result);
    }

    @Test
    public void testisItemIsFailCorrectlyImplemented() {
        String result = snowGolem.isItem("Homa", "Homa");
        String expected = "item Homa is Homa";
        assertEquals(expected, result);
    }

    @Test
    public void testSnowGolemOverridePunch() throws Exception {
        Method punch = snowGolemClass.getDeclaredMethod("punch", Punchable.class);

        assertEquals("java.lang.String",
            punch.getGenericReturnType().getTypeName());
        assertEquals(1, punch.getParameterCount());
        assertTrue(Modifier.isPublic(punch.getModifiers()));
    }

    @Test
    public void testPunchIsCorrectlyImplemented() {
        String result = snowGolem.punch(Punchable.CraneLever);
        assertEquals("Punching CraneLever", result);
    }

    @Test
    public void testSnowGolemOverrideToss() throws Exception {
        Method toss = snowGolemClass.getDeclaredMethod("toss", String.class);

        assertEquals("java.lang.String",
            toss.getGenericReturnType().getTypeName());
        assertEquals(1, toss.getParameterCount());
        assertTrue(Modifier.isPublic(toss.getModifiers()));
    }

    @Test
    public void testTossIsCorrectlyImplemented() {
        String result = snowGolem.toss("Box");
        assertEquals("Tossing Box with two hand", result);
    }

    @Test
    public void testSnowGolemOverrideGetNameMethod() throws Exception {
        Method getName = snowGolemClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = snowGolem.getName();
        assertEquals("Joergen", result);
    }
}
