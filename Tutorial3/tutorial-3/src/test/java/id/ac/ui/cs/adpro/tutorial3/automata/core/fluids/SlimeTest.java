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

public class SlimeTest {

    private Class<?> slimeClass;
    private Slime slime;

    @BeforeEach
    public void setUp() throws Exception {
        slimeClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Slime");
        slime = new Slime("Geo");
    }

    @Test
    public void testSlimeIsConcreteClass() {
        assertFalse(Modifier.isAbstract(slimeClass.getModifiers()));
    }

    @Test
    public void testSlimeIsAFluids() {
        Collection<Type> interfaces = Arrays.asList(slimeClass.getInterfaces());

        assertTrue(interfaces.stream()
            .anyMatch(type -> type.getTypeName()
                .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids")));
    }

    @Test
    public void testSlimeOverridePushItemMethod() throws Exception {
        Class<?>[] pushItemArgs = new Class[2];
        pushItemArgs[0] = String.class;
        pushItemArgs[1] = Direction.class;
        Method pushItem = slimeClass.getDeclaredMethod("pushItem", pushItemArgs);

        assertEquals("java.lang.String",
            pushItem.getGenericReturnType().getTypeName());
        assertEquals(2, pushItem.getParameterCount());
        assertTrue(Modifier.isPublic(pushItem.getModifiers()));
    }

    @Test
    public void testPushItemIsCorrectlyImplemented() {
        String result = slime.pushItem("box", Direction.Up);
        assertEquals("Pushing box Up", result);
    }

    @Test
    public void testSlimeOverrideSplitByMethod() throws Exception {
        Class<?>[] splitByArgs = new Class[2];
        splitByArgs[0] = List.class;
        splitByArgs[1] = String.class;
        Method splitBy = slimeClass.getDeclaredMethod("splitBy", splitByArgs);

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
        String result = slime.splitBy(items, "Box");
        assertEquals("11", result);
    }

    @Test
    public void testSlimeOverrideShapeShiftMethod() throws Exception {
        Method shapeShift = slimeClass.getDeclaredMethod("shapeShift", Shape.class);

        assertEquals("java.lang.String",
            shapeShift.getGenericReturnType().getTypeName());
        assertEquals(1, shapeShift.getParameterCount());
        assertTrue(Modifier.isPublic(shapeShift.getModifiers()));
    }

    @Test
    public void testShapeShiftIsCorrectlyImplemented() {
        String result = slime.shapeShift(Shape.Crane);
        assertEquals("Shape shift into Crane", result);

        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        slime.splitBy(items, "Box");

        String result2 = slime.shapeShift(Shape.Transporter);
        assertEquals("Not enough body to shape shift", result2);
    }

    @Test
    public void testSlimeOverrideMergeMethod() throws Exception {
        Method merge = slimeClass.getDeclaredMethod("merge");

        assertEquals("java.lang.String",
            merge.getGenericReturnType().getTypeName());
        assertEquals(0, merge.getParameterCount());
        assertTrue(Modifier.isPublic(merge.getModifiers()));
    }

    @Test
    public void testMergeIsCorrectlyImplemented() {
        String result = slime.merge();
        assertEquals("Merging bodies", result);
    }

    @Test
    public void testSlimeOverrideGetNameMethod() throws Exception {
        Method getName = slimeClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
            getName.getGenericReturnType().getTypeName());
        assertEquals(0, getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = slime.getName();
        assertEquals("Geo", result);
    }
}
