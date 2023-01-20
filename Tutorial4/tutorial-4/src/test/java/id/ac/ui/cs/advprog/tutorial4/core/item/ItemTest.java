package id.ac.ui.cs.advprog.tutorial4.core.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ItemTest {
    private Class<?> itemClass;

    @BeforeEach
    public void setup() throws Exception {
        itemClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.item.Item");
    }

    @Test
    public void testItemIsAPublicInterface() {
        int classModifiers = itemClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testItemHasGetNameAbstractMethod() throws Exception {
        Method getName = itemClass.getDeclaredMethod("getName");
        int methodModifiers = getName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getName.getParameterCount());
    }
}
