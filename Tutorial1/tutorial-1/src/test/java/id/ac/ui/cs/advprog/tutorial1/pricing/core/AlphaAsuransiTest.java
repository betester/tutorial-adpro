package id.ac.ui.cs.advprog.tutorial1.pricing.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class AlphaAsuransiTest {

    private Class<?> alphaAsuransiClass;
    private Asuransi alphaAsuransi;

    @BeforeEach
    public void setUp() throws Exception{
        alphaAsuransiClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.pricing.core.AlphaAsuransi");
        alphaAsuransi = new AlphaAsuransi(1000);
    }

    @Test
    public void testAlphaAsuransiIsConcreteClass(){
        assertFalse(Modifier.isAbstract(alphaAsuransiClass.getModifiers()));
        assertFalse(Modifier.isInterface(alphaAsuransiClass.getModifiers()));
    }

    @Test
    public void testAlphaAsuransiHasGetNameMethod() throws Exception{
        Method getName = alphaAsuransiClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    public void testAlphaAsuransiHasGetPriceMethod() throws Exception{
        Method getPrice = alphaAsuransiClass.getDeclaredMethod("getPrice");

        assertTrue(Modifier.isPublic(getPrice.getModifiers()));
        assertEquals(0, getPrice.getParameterCount());
        assertEquals("int", getPrice.getGenericReturnType().getTypeName());
    }

    @Test
    public void testAlphaAsuransiGetNameMethodReturnAsuransiName() {

        assertEquals("Alpha", alphaAsuransi.getName());
    }

    @Test
    public void testAlphaAsuransiGePriceMethodReturnPrice() {

        assertEquals(1000, alphaAsuransi.getPrice());
    }

}
