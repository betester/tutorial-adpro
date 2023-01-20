package id.ac.ui.cs.adpro.tutorial3.automata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Gemini;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.R2;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Slime;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Symbiote;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.IronGolem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.SnowGolem;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.DroidRepositoryImpl;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.FluidsRepository;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.GolemRepository;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.InventoryRepository;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.LoggerRepository;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class DroidServiceTest {
    private Class<?> droidServiceClass;

    @Mock
    FluidsRepository fluidsRepository;

    @Mock
    GolemRepository golemRepository;

    @Mock
    LoggerRepository loggerRepository;

    @Mock
    InventoryRepository inventoryRepository;

    @Spy
    DroidRepositoryImpl droidRepository = new DroidRepositoryImpl();

    @InjectMocks
    DroidService droidService = new DroidServiceImpl();

    @BeforeEach
    public void setUp() throws Exception {
        droidServiceClass = Class.forName(
            "id.ac.ui.cs.adpro.tutorial3.automata.service.DroidServiceImpl");
    }

    @Test
    public void testDroidServiceFetchDroidMethod() throws Exception {
        Method fetchDroids = droidServiceClass.getDeclaredMethod("fetchDroids");
        int methodModifier = fetchDroids.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));

        ParameterizedType pt = (ParameterizedType) fetchDroids.getGenericReturnType();
        assertEquals(List.class, pt.getRawType());
        assertTrue(Arrays.asList(pt.getActualTypeArguments()).contains(Droid.class));
    }

    @Test
    public void testDroidServiceFetchAllReturnCorrectAmount() {
        List<Fluids> mockListFluids = new ArrayList<>();
        mockListFluids.add(new Slime("Geo"));
        mockListFluids.add(new Symbiote("Carnage"));

        List<Golem> mockListGolem = new ArrayList<>();
        mockListGolem.add(new IronGolem("Ito"));
        mockListGolem.add(new SnowGolem("Elaine"));

        droidRepository.add(new R2("D2"));

        when(fluidsRepository.findAll()).thenReturn(mockListFluids);
        when(golemRepository.findAll()).thenReturn(mockListGolem);

        assertEquals(5, droidService.fetchDroids().size());
        verify(droidRepository, atLeastOnce()).findAll();
        verify(fluidsRepository, atLeastOnce()).findAll();
        verify(golemRepository, atLeastOnce()).findAll();
    }

    @Test
    public void testDroidServiceFetchInventoriesMethod() throws Exception {
        Method fetchInventories = droidServiceClass.getDeclaredMethod("fetchInventories");
        assertTrue(Modifier.isPublic(fetchInventories.getModifiers()));

        ParameterizedType pt = (ParameterizedType) fetchInventories.getGenericReturnType();
        assertEquals(List.class, pt.getRawType());
        assertTrue(Arrays.asList(pt.getActualTypeArguments()).contains(String.class));
    }

    @Test
    public void testDroidServiceFetchInventoriesReturnAllInventory() {
        droidService.fetchInventories();
        verify(inventoryRepository, atLeastOnce()).fetchInventory();
    }

    @Test
    public void testDroidServiceAddInventoryMethod() throws Exception {
        Method addInventory = droidServiceClass.getDeclaredMethod("addInventory", String.class);
        assertTrue(Modifier.isPublic(addInventory.getModifiers()));
    }

    @Test
    public void testDroidServiceAddInventoryImplementedCorrectly() {
        droidService.addInventory("Box");
        verify(inventoryRepository, atLeastOnce()).addItem("Box");
    }

    @Test
    public void testDroidServiceFetchLogsMethod() throws Exception {
        Method fetchLogs = droidServiceClass.getDeclaredMethod("fetchLogs");
        int methodModifier = fetchLogs.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));

        ParameterizedType pt = (ParameterizedType) fetchLogs.getGenericReturnType();
        assertEquals(List.class, pt.getRawType());
        assertTrue(Arrays.asList(pt.getActualTypeArguments()).contains(String.class));
    }

    @Test
    public void testDroidServiceFetchLogsReturnAllLogs() {
        droidService.fetchLogs();
        verify(loggerRepository, atLeastOnce()).getLogs();
    }

    @Test
    public void testDroidServiceDoRoutineMethod() throws Exception {
        Method doRoutine = droidServiceClass.getDeclaredMethod("doRoutine", String.class, int.class);
        int methodModifier = doRoutine.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
    }

    @Test
    public void testDroidServiceDoRoutineCorrectlyImplemented() throws NoSuchMethodException {
        List<Droid> mockListDroid = new ArrayList<>();
        mockListDroid.add(new Gemini("Virgo"));
        List<String> inventory = new ArrayList<>();
        inventory.add("TNT");
        ReflectionTestUtils.setField(droidService, "units", mockListDroid);

        droidService.doRoutine("Virgo", 0);
        when(inventoryRepository.fetchInventory()).thenReturn(inventory);
        droidService.doRoutine("Virgo", 1);
        droidService.doRoutine("Virgo", 2);
        droidService.doRoutine("Virgo", 3);
        droidService.doRoutine("Virgo", 4);
        droidService.doRoutine("Alpha", 1);

        Method recordLog = droidServiceClass.getDeclaredMethod("recordLog", Droid.class, String.class);
        assertTrue(Modifier.isProtected(recordLog.getModifiers()));
    }
}
