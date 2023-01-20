package id.ac.ui.cs.advprog.tutorial1.pricing.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KudaKurirTest {

    private Class<?> kudaKurirClass;
    private Kurir kudaKurir;

    @BeforeEach
    public void setUp() throws Exception{
        kudaKurirClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.pricing.core.KudaKurir");
        kudaKurir = new KudaKurir(100);
    }

    @Test
    public void testKudaKurirIsConcreteClass(){
        assertFalse(Modifier.isAbstract(kudaKurirClass.getModifiers()));
        assertFalse(Modifier.isInterface(kudaKurirClass.getModifiers()));
    }

    @Test
    public void testKudaKurirHasGetNameMethod() throws Exception{
        Method getName = kudaKurirClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    public void testKudaKurirHasCalculatePriceMethod() throws Exception{
        Method getPrice = kudaKurirClass.getDeclaredMethod("calculatePrice", int.class);

        assertTrue(Modifier.isPublic(getPrice.getModifiers()));
        assertEquals(1, getPrice.getParameterCount());
        assertEquals("int", getPrice.getGenericReturnType().getTypeName());
    }

    @Test
    public void testKudaKurirGetNameMethodReturnKurirName() {

        assertEquals("Kuda", kudaKurir.getName());
    }

    @Test
    public void testKudaKurirCalculatePriceMethodReturnCorrectPrice() {

        assertEquals(2500, kudaKurir.calculatePrice(25));
    }
    
}
