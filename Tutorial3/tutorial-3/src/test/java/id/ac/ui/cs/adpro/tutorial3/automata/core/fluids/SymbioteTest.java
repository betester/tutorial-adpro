package id.ac.ui.cs.adpro.tutorial3.automata.core.fluids;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SymbioteTest {

    private Class<?> symbioteClass;
    private Symbiote symbiote;

    @BeforeEach
    public void setUp() throws Exception {
        symbioteClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Symbiote");
        symbiote = new Symbiote("Carnage");
    }

    @Test
    public void testSymbioteIsConcreteClass() {
        assertFalse(Modifier.isAbstract(symbioteClass.getModifiers()));
    }

    @Test
    public void testSymbioteIsAFluids() {
        Collection<Type> interfaces = Arrays.asList(symbioteClass.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids")));
    }

    @Test
    public void testSymbioteOverridePushItemMethod() throws Exception {
        Class<?>[] pushItemArgs = new Class[2];
        pushItemArgs[0] = String.class;
        pushItemArgs[1] = Direction.class;
        Method pushItem = symbioteClass.getDeclaredMethod("pushItem", pushItemArgs);

        assertEquals("java.lang.String",
            pushItem.getGenericReturnType().getTypeName());
        assertEquals(2, pushItem.getParameterCount());
        assertTrue(Modifier.isPublic(pushItem.getModifiers()));
    }

    @Test
    public void testPushItemIsCorrectlyImplemented() {
        String result = symbiote.pushItem("box", Direction.Up);
        assertEquals("Pushing box Up", result);
    }

    @Test
    public void testSymbioteOverrideSplitByMethod() throws Exception {
        Class<?>[] splitByArgs = new Class[2];
        splitByArgs[0] = List.class;
        splitByArgs[1] = String.class;
        Method splitBy = symbioteClass.getDeclaredMethod("splitBy", splitByArgs);

        assertEquals("java.lang.String",
            splitBy.getGenericReturnType().getTypeName());
        assertEquals(2, splitBy.getParameterCount());
        assertTrue(Modifier.isPublic(splitBy.getModifiers()));
    }

    @Test
    public void testSplitByCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        items.add("Homa");
        items.add("Box");
        items.add("Box");
        String result = symbiote.splitBy(items, "Box");
        assertEquals("11", result);
    }

    @Test
    public void testSymbioteOverrideShapeShiftMethod() throws Exception {
        Class<?>[] shapeShiftArgs = new Class[1];
        shapeShiftArgs[0] = Shape.class;
        Method shapeShift = symbioteClass.getDeclaredMethod("shapeShift", shapeShiftArgs);

        assertEquals("java.lang.String",
            shapeShift.getGenericReturnType().getTypeName());
        assertEquals(1, shapeShift.getParameterCount());
        assertTrue(Modifier.isPublic(shapeShift.getModifiers()));
    }

    @Test
    public void testSplitBySymbioteCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        items.add("Homa");
        items.add("Box");
        items.add("Box");
        String result = symbiote.splitBy(items, "Homa");
        assertEquals("10", result);
    }

    @Test
    public void testSymbioteOverrideMergeMethod() throws Exception {
        Method merge = symbioteClass.getDeclaredMethod("merge");

        assertEquals("java.lang.String",
            merge.getGenericReturnType().getTypeName());
        assertEquals(0, merge.getParameterCount());
        assertTrue(Modifier.isPublic(merge.getModifiers()));
    }

    @Test
    public void testMergeIsCorrectlyImplemented() {
        String result = symbiote.merge();
        assertEquals("Collecting bodies", result);
    }

    @Test
    public void testSymbioteOverrideGetNameMethod() throws Exception {
        Method getName = symbioteClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = symbiote.getName();
        assertEquals("Carnage", result);
    }
}
