package id.ac.ui.cs.advprog.tutorial4.core.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MerchItemTest {
    private Class<?> merchItemClass;

    @BeforeEach
    public void setUp() throws Exception {
        merchItemClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem");
    }

    @Test
    public void testMerchItemIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(merchItemClass.getModifiers()));
    }

    @Test
    public void testMerchItemIsASpell() {
        Collection<Type> interfaces = Arrays.asList(merchItemClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.core.item.Item")));
    }

    @Test
    public void testMerchItemOverrideGetNameMethod() throws Exception {
        Method getName = merchItemClass.getDeclaredMethod("getName");
        MerchItem merchItem = mock(MerchItem.class);

        merchItem.getName();

        verify(merchItem, times(1)).getName();
        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
    }

    @Test
    public void testGetNameShouldReturnCorrectly() throws Exception {
        MerchItem merchItem = new MerchItem("dummyMerch");

        String name = merchItem.getName();

        assertEquals("dummyMerch", name);
    }

    @Test
    public void testSetNameShouldChangeName() throws Exception {
        MerchItem merchItem = new MerchItem("dummyMerch");

        merchItem.setName("dummyItem");
        String name = merchItem.getName();

        assertEquals("dummyItem", name);
    }
}
