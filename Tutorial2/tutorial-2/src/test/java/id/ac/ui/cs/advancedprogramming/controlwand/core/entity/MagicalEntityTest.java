package id.ac.ui.cs.advancedprogramming.controlwand.core.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MagicalEntityTest {
    private String magicalEntityName;
    private MagicalEntity magicalEntity;

    @BeforeEach
    public void setUp() {
        magicalEntityName = "mockName";
        magicalEntity = Mockito.mock(MagicalEntity.class,
                Mockito.withSettings().useConstructor(magicalEntityName).defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    public void whenGetNameIsCalledItShouldReturnTheObjectName() {
        assertEquals(magicalEntityName, magicalEntity.getName());
    }

    @Test
    public void whenDefineStateIsCalledItShouldReturnStringAboutCurrentState() {
        MagicalEntityState state = Mockito.mock(MagicalEntityState.class);
        String definedStateString = "Casted state";
        when(magicalEntity.defineState(state)).thenReturn(definedStateString);

        String calledDefineState = magicalEntity.defineState(state);
        assertEquals(definedStateString, calledDefineState);
    }

    @Test
    public void whenGetCurrentStateItShouldReturnTheCorrectState() throws Exception {
        Field currentStateField = MagicalEntity.class.getDeclaredField("currentState");
        currentStateField.setAccessible(true);
        MagicalEntityState state = Mockito.mock(MagicalEntityState.class);
        currentStateField.set(magicalEntity, state);

        assertEquals(state, magicalEntity.getCurrentState());
    }

    @Test
    public void whenGetLifeArchiveItShouldReturnAListOfDefinedStates() throws Exception {
        MagicalEntityState state = Mockito.mock(MagicalEntityState.class);
        String definedStateString = "Casted state";
        when(magicalEntity.defineState(state)).thenReturn(definedStateString);

        Field stateHistoryField = MagicalEntity.class.getDeclaredField("stateHistory");
        stateHistoryField.setAccessible(true);
        List<MagicalEntityState> magicalEntityStateList = new ArrayList<>();
        magicalEntityStateList.add(state);
        magicalEntityStateList.add(state);
        stateHistoryField.set(magicalEntity, magicalEntityStateList);

        List<String> calledGetLifeArchive = magicalEntity.getLifeArchive();
        assertEquals(2, calledGetLifeArchive.size());
        assertEquals(definedStateString, calledGetLifeArchive.get(0));
        assertEquals(definedStateString, calledGetLifeArchive.get(1));
    }
}
