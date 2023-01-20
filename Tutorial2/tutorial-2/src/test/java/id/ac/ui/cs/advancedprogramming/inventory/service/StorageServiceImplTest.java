package id.ac.ui.cs.advancedprogramming.inventory.service;

import id.ac.ui.cs.advancedprogramming.inventory.core.DummyType;
import id.ac.ui.cs.advancedprogramming.inventory.repository.DummyStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StorageServiceImplTest {
    @Mock
    private DummyStorage dummyStorage;

    @InjectMocks
    private StorageServiceImpl storageService;

    @Test
    public void whenGetDummiesIsCalledItShouldCallDummyStorageGetDummiesMethod() {
        storageService.getDummies();
        verify(dummyStorage, times(1)).getDummies();
    }

    @Test
    public void whenGetDummyByIndexIsCalledItShouldCallDummyStorageGetDummyByIndexMethod() {
        int index = 1;
        storageService.getDummy(index);
        verify(dummyStorage, times(1)).getDummy(index);
    }

    @Test
    public void whenRemoveDummyByIndexIsCalledItShouldCallDummyStorageRemoveDummyByIndexMethod() {
        int index = 1;
        storageService.removeDummy(index);
        verify(dummyStorage, times(1)).removeDummy(index);
    }

    @Test
    public void whenCreateDummyIsCalledItShouldCallRepositoryCreateDummyMethod() {
        float weight = 10;
        DummyType type = DummyType.MELEE;
        String weapon = "Sword";

        storageService.createDummy(weight, type, weapon);

        verify(dummyStorage, times(1)).createDummy(weight, type, weapon);
    }
}
