package id.ac.ui.cs.advprog.tutorial1.pricing.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SigmaAsuransiTest {
    
    private Class<?> sigmaAsuransiClass;
    private Asuransi sigmaAsuransi;

    @BeforeEach
    public void setUp() throws Exception{
        sigmaAsuransiClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.pricing.core.SigmaAsuransi");
        sigmaAsuransi = new SigmaAsuransi(5000);
    }

    @Test
    public void testSigmaAsuransiIsConcreteClass(){
        assertFalse(Modifier.isAbstract(sigmaAsuransiClass.getModifiers()));
        assertFalse(Modifier.isInterface(sigmaAsuransiClass.getModifiers()));
    }

    @Test
    public void testSigmaAsuransiHasGetNameMethod() throws Exception{
        Method getName = sigmaAsuransiClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    public void testSigmaAsuransiHasGetPriceMethod() throws Exception{
        Method getPrice = sigmaAsuransiClass.getDeclaredMethod("getPrice");

        assertTrue(Modifier.isPublic(getPrice.getModifiers()));
        assertEquals(0, getPrice.getParameterCount());
        assertEquals("int", getPrice.getGenericReturnType().getTypeName());
    }

    @Test
    public void testSigmaAsuransiGetNameMethodReturnAsuransiName() {

        assertEquals("Sigma", sigmaAsuransi.getName());
    }

    @Test
    public void testSigmaAsuransiGePriceMethodReturnPrice() {

        assertEquals(5000, sigmaAsuransi.getPrice());
    }
    
}
