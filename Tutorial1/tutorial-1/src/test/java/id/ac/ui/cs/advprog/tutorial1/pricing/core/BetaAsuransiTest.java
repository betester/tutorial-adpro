package id.ac.ui.cs.advprog.tutorial1.pricing.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BetaAsuransiTest {

    private Class<?> betaAsuransiClass;
    private Asuransi betaAsuransi;

    @BeforeEach
    public void setUp() throws Exception{
        betaAsuransiClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.pricing.core.BetaAsuransi");
        betaAsuransi = new BetaAsuransi(200);
    }

    @Test
    public void testBetaAsuransiIsConcreteClass(){
        assertFalse(Modifier.isAbstract(betaAsuransiClass.getModifiers()));
        assertFalse(Modifier.isInterface(betaAsuransiClass.getModifiers()));
    }

    @Test
    public void testBetaAsuransiHasGetNameMethod() throws Exception{
        Method getName = betaAsuransiClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    public void testBetaAsuransiHasGetPriceMethod() throws Exception{
        Method getPrice = betaAsuransiClass.getDeclaredMethod("getPrice");

        assertTrue(Modifier.isPublic(getPrice.getModifiers()));
        assertEquals(0, getPrice.getParameterCount());
        assertEquals("int", getPrice.getGenericReturnType().getTypeName());
    }

    @Test
    public void testBetaAsuransiGetNameMethodReturnAsuransiName() {

        assertEquals("Beta", betaAsuransi.getName());
    }

    @Test
    public void testBetaAsuransiGePriceMethodReturnPrice() {

        assertEquals(200, betaAsuransi.getPrice());
    }

}
