package id.ac.ui.cs.advancedprogramming.inventory.core;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DummyTest {
    @Test
    public void testDummyGettersShouldReturnCorrectValues() {
        float dummyWeight = 10;
        DummyType dummyType = DummyType.MELEE;
        String dummyWeapon = "Greatsword";
        Dummy mockDummy = Mockito.mock(
                Dummy.class,
                Mockito.withSettings()
                        .useConstructor(dummyWeight, dummyType, dummyWeapon)
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS)
        );

        assertEquals(dummyWeight, mockDummy.getWeight());
        assertEquals(dummyType, mockDummy.getType());
        assertEquals(dummyWeapon, mockDummy.getWeapon());
        assertTrue(mockDummy.getDummyLog() instanceof ArrayList);
    }
}
