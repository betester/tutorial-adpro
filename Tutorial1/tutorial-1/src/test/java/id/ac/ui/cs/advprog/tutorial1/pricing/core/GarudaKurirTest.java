package id.ac.ui.cs.advprog.tutorial1.pricing.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GarudaKurirTest {

    private Class<?> garudaKurirClass;
    private Kurir garudaKurir;

    @BeforeEach
    public void setUp() throws Exception{
        garudaKurirClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.pricing.core.GarudaKurir");
        garudaKurir = new GarudaKurir(100);
    }

    @Test
    public void testGarudaKurirIsConcreteClass(){
        assertFalse(Modifier.isAbstract(garudaKurirClass.getModifiers()));
        assertFalse(Modifier.isInterface(garudaKurirClass.getModifiers()));
    }

    @Test
    public void testGarudaKurirHasGetNameMethod() throws Exception{
        Method getName = garudaKurirClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    public void testGarudaKurirHasCalculatePriceMethod() throws Exception{
        Method getPrice = garudaKurirClass.getDeclaredMethod("calculatePrice", int.class);

        assertTrue(Modifier.isPublic(getPrice.getModifiers()));
        assertEquals(1, getPrice.getParameterCount());
        assertEquals("int", getPrice.getGenericReturnType().getTypeName());
    }

    @Test
    public void testGarudaKurirGetNameMethodReturnKurirName() {

        assertEquals("Garuda", garudaKurir.getName());
    }

    @Test
    public void testGarudaKurirCalculatePriceMethodReturnCorrectPrice() {

        assertEquals(12000, garudaKurir.calculatePrice(100));
    }
}
