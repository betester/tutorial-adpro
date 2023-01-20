package id.ac.ui.cs.advprog.tutorial1.pricing.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KadalKurirTest {

    private Class<?> kadalKurirClass;
    private Kurir kadalKurir;

    @BeforeEach
    public void setUp() throws Exception{
        kadalKurirClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.pricing.core.KadalKurir");
        kadalKurir = new KadalKurir(10);
    }

    @Test
    public void testKadalKurirIsConcreteClass(){
        assertFalse(Modifier.isAbstract(kadalKurirClass.getModifiers()));
        assertFalse(Modifier.isInterface(kadalKurirClass.getModifiers()));
    }

    @Test
    public void testKadalKurirHasGetNameMethod() throws Exception{
        Method getName = kadalKurirClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    public void testKadalKurirHasCalculatePriceMethod() throws Exception{
        Method getPrice = kadalKurirClass.getDeclaredMethod("calculatePrice", int.class);

        assertTrue(Modifier.isPublic(getPrice.getModifiers()));
        assertEquals(1, getPrice.getParameterCount());
        assertEquals("int", getPrice.getGenericReturnType().getTypeName());
    }

    @Test
    public void testKadalKurirGetNameMethodReturnKurirName() {

        assertEquals("Kadal", kadalKurir.getName());
    }

    @Test
    public void testKadalKurirCalculatePriceMethodReturnCorrectPrice() {

        assertEquals(70, kadalKurir.calculatePrice(7));
    }
    
}
