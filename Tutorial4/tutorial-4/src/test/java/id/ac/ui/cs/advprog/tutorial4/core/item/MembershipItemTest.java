package id.ac.ui.cs.advprog.tutorial4.core.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MembershipItemTest {
    private Class<?> membershipItemClass;

    @BeforeEach
    public void setUp() throws Exception {
        membershipItemClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem");
    }

    @Test
    public void testMembershipItemIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(membershipItemClass.getModifiers()));
    }

    @Test
    public void testMembershipItemIsASpell() {
        Collection<Type> interfaces = Arrays.asList(membershipItemClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.core.item.Item")));
    }

    @Test
    public void testMembershipItemOverrideGetNameMethod() throws Exception {
        Method getName = membershipItemClass.getDeclaredMethod("getName");
        MembershipItem membershipItem = mock(MembershipItem.class);

        membershipItem.getName();

        verify(membershipItem, times(1)).getName();
        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
    }

    @Test
    public void testGetNameShouldReturnCorrectly() throws Exception {
        MembershipItem membershipItem = new MembershipItem("dummyMembership");

        String name = membershipItem.getName();

        assertEquals("dummyMembership", name);
    }

    @Test
    public void testSetNameShouldChangeName() throws Exception {
        MembershipItem membershipItem = new MembershipItem("dummyMembership");

        membershipItem.setName("dummyItem");
        String name = membershipItem.getName();

        assertEquals("dummyItem", name);
    }
}
