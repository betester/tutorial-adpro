package id.ac.ui.cs.advancedprogramming.inventory.repository;

import id.ac.ui.cs.advancedprogramming.inventory.core.Dummy;
import id.ac.ui.cs.advancedprogramming.inventory.core.DummyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DummyStorageTest {
    private DummyStorage dummyStorage;

    @BeforeEach
    public void setUp() {
        dummyStorage = new DummyStorage();
    }

    @Test
    public void whenGetDummiesIsCalledItShouldReturnDummiesList() throws Exception {
        Dummy mockDummy = Mockito.mock(Dummy.class, Mockito.CALLS_REAL_METHODS);
        Field dummiesListClassField = dummyStorage.getClass().getDeclaredField("dummies");

        List<Dummy> calledDummyList;
        calledDummyList = dummyStorage.getDummies();
        assertFalse(calledDummyList.contains(mockDummy));
        assertEquals(0, calledDummyList.size());

        dummiesListClassField.setAccessible(true);
        List<Dummy> testDummyList = new ArrayList<>();
        testDummyList.add(mockDummy);
        dummiesListClassField.set(dummyStorage, testDummyList);

        calledDummyList = dummyStorage.getDummies();
        assertTrue(calledDummyList.contains(mockDummy));
        assertEquals(1, calledDummyList.size());
    }

    @Test
    public void whenRemoveDummyByIndexItShouldNotContainTheDummyObjectAtThatIndex() throws Exception {
        Dummy mockDummy = Mockito.mock(Dummy.class, Mockito.CALLS_REAL_METHODS);
        Field dummiesListClassField = dummyStorage.getClass().getDeclaredField("dummies");

        dummiesListClassField.setAccessible(true);
        List<Dummy> testDummyList = new ArrayList<>();
        testDummyList.add(mockDummy);
        dummiesListClassField.set(dummyStorage, testDummyList);

        List<Dummy> calledDummyList;
        calledDummyList = dummyStorage.getDummies();
        assertTrue(calledDummyList.contains(mockDummy));
        assertEquals(1, calledDummyList.size());

        dummyStorage.removeDummy(0);

        assertFalse(calledDummyList.contains(mockDummy));
        assertEquals(0, calledDummyList.size());
    }

    @Test
    public void whenGetDummyByIndexItShouldReturnTheDummyAtThatIndex() throws Exception {
        Dummy mockDummy = Mockito.mock(Dummy.class, Mockito.CALLS_REAL_METHODS);
        Field dummiesListClassField = dummyStorage.getClass().getDeclaredField("dummies");

        dummiesListClassField.setAccessible(true);
        List<Dummy> testDummyList = new ArrayList<>();
        testDummyList.add(mockDummy);
        dummiesListClassField.set(dummyStorage, testDummyList);

        Dummy calledDummy = dummyStorage.getDummy(0);
        assertEquals(calledDummy, mockDummy);
    }

    @Test
    public void whenCreateDummyIsCalledItShouldCallDummyQualityCheckThenAddDummyToDummiesList() throws Exception {
        float dummyWeight = 10;
        DummyType dummyType = DummyType.MELEE;
        String dummyWeapon = "Greatsword";
        Dummy mockDummy = Mockito.mock(
                Dummy.class,
                Mockito.withSettings()
                        .useConstructor(dummyWeight, dummyType, dummyWeapon)
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS)
        );

        mockDummy.qualityCheck();

        verify(mockDummy, times(1)).qualityCheck();

        Field dummiesListClassField = dummyStorage.getClass().getDeclaredField("dummies");
        dummiesListClassField.setAccessible(true);
        List<Dummy> testDummyList = new ArrayList<>();
        testDummyList.add(mockDummy);
        dummiesListClassField.set(dummyStorage, testDummyList);

        assertEquals(1, dummyStorage.getDummies().size());
        assertTrue(dummyStorage.getDummies().contains(mockDummy));
    }
}
