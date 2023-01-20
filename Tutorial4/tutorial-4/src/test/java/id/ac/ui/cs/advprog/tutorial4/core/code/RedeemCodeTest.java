package id.ac.ui.cs.advprog.tutorial4.core.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedeemCodeTest {
    private Class<?> redeemCodeClass;

    @BeforeEach
    public void setup() throws Exception {
        redeemCodeClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode");
    }

    @Test
    public void testRedeemCodeIsAPublicInterface() {
        int classModifiers = redeemCodeClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testRedeemCodeHasGetCodeAbstractMethod() throws Exception {
        Method getCode = redeemCodeClass.getDeclaredMethod("getCode");
        int methodModifiers = getCode.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getCode.getParameterCount());
    }

    @Test
    public void testRedeemCodeHasRedeemAbstractMethod() throws Exception {
        Method redeem = redeemCodeClass.getDeclaredMethod("redeem");
        int methodModifiers = redeem.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, redeem.getParameterCount());
    }

    @Test
    public void testRedeemCodeHasIsRedeemedAbstractMethod() throws Exception {
        Method isRedeemed = redeemCodeClass.getDeclaredMethod("isRedeemed");
        int methodModifiers = isRedeemed.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, isRedeemed.getParameterCount());
    }
}
