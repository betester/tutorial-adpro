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

public class IronGolemTest {

    private Class<?> ironGolemClass;
    private IronGolem ironGolem;

    @BeforeEach
    public void setUp() throws Exception {
        ironGolemClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.golem.IronGolem");
        ironGolem = new IronGolem("Dinnerbone");
    }

    @Test
    public void testIronGolemIsConcreteClass() {
        assertFalse(Modifier.isAbstract(ironGolemClass.getModifiers()));
    }

    @Test
    public void testIronGolemIsAGolem() {
        Collection<Type> interfaces = Arrays.asList(ironGolemClass.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem")));
    }

    @Test
    public void testIronGolemOverrideLiftItemMethod() throws Exception {
        Method liftItem = ironGolemClass.getDeclaredMethod("liftItem", String.class);

        assertEquals("java.lang.String",
            liftItem.getGenericReturnType().getTypeName());
        assertEquals(1, liftItem.getParameterCount());
        assertTrue(Modifier.isPublic(liftItem.getModifiers()));
    }

    @Test
    public void testLiftItemIsCorrectlyImplemented() {
        String result = ironGolem.liftItem("box");
        assertEquals("Carefully lifting box", result);
    }

    @Test
    public void testIronGolemHasIsItemMethod() throws Exception {
        Class<?>[] countItemArgs = new Class[2];
        countItemArgs[0] = String.class;
        countItemArgs[1] = String.class;
        Method countItem = ironGolemClass.getDeclaredMethod("isItem", countItemArgs);

        assertEquals("java.lang.String",
            countItem.getGenericReturnType().getTypeName());
        assertEquals(2, countItem.getParameterCount());
        assertTrue(Modifier.isPublic(countItem.getModifiers()));
    }

    @Test
    public void testisItemIsCorrectlyImplemented() {
        String result = ironGolem.isItem("Homa", "Box");
        String expected = "item Homa is not Box";
        assertEquals(expected, result);
    }

    @Test
    public void testisItemIsFailCorrectlyImplemented() {
        String result = ironGolem.isItem("Homa", "Homa");
        String expected = "item Homa is Homa";
        assertEquals(expected, result);
    }

    @Test
    public void testIronGolemOverridePunch() throws Exception {
        Method punch = ironGolemClass.getDeclaredMethod("punch", Punchable.class);

        assertEquals("java.lang.String",
            punch.getGenericReturnType().getTypeName());
        assertEquals(1, punch.getParameterCount());
        assertTrue(Modifier.isPublic(punch.getModifiers()));
    }

    @Test
    public void testPunchIsCorrectlyImplemented() {
        String result = ironGolem.punch(Punchable.CraneLever);
        assertEquals("Punching CraneLever", result);
    }

    @Test
    public void testIronGolemOverrideToss() throws Exception {
        Method toss = ironGolemClass.getDeclaredMethod("toss", String.class);

        assertEquals("java.lang.String",
            toss.getGenericReturnType().getTypeName());
        assertEquals(1, toss.getParameterCount());
        assertTrue(Modifier.isPublic(toss.getModifiers()));
    }

    @Test
    public void testTossIsCorrectlyImplemented() {
        String result = ironGolem.toss("Hillichurl");
        assertEquals("Tossing Hillichurl with one hand", result);
    }

    @Test
    public void testIronGolemOverrideGetNameMethod() throws Exception {
        Method getName = ironGolemClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = ironGolem.getName();
        assertEquals("Dinnerbone", result);
    }
}
