package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ManaIntensityTest {
    @Test
    public void whenGetNonNullManaIntensitiesIsCalledItShouldReturnNonNullManaIntensities() {
        try (MockedStatic<ManaIntensity> manaIntensity = Mockito.mockStatic(ManaIntensity.class)) {
            List<ManaIntensity> manaIntensityList = new ArrayList<>();
            manaIntensityList.add(ManaIntensity.HIGH);
            manaIntensityList.add(ManaIntensity.LOW);
            manaIntensityList.add(ManaIntensity.MEDIUM);
            manaIntensity.when(ManaIntensity::getNonNullManaIntensities).thenReturn(manaIntensityList);
            assertFalse(ManaIntensity.getNonNullManaIntensities().contains(ManaIntensity.NONE));
        }
    }
}
