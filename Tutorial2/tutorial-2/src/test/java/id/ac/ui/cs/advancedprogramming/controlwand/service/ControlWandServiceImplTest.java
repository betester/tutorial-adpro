package id.ac.ui.cs.advancedprogramming.controlwand.service;

import id.ac.ui.cs.advancedprogramming.controlwand.repository.ControlWand;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.EntityCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ControlWandServiceImplTest {
    @Mock
    private ControlWand controlWand;

    @Mock
    private EntityCollection entityCollection;

    @InjectMocks
    private ControlWandServiceImpl controlWandService;

    @Test
    public void whenCastSpellIsCalledItShouldCallControlWandCastMethod() {
        String spellName = "Test Spell";
        controlWandService.castSpell(spellName);
        verify(controlWand, times(1)).cast(spellName);
    }

    @Test
    public void whenUndoSpellIsCalledItShouldCallControlWandUndoSpellMethod() {
        controlWandService.undoSpell();
        verify(controlWand, times(1)).undo();
    }

    @Test
    public void whenGetSpellNamesIsCalledItShouldCallControlWandGetSpellNamesMethod() {
        controlWandService.getSpellNames();
        verify(controlWand, times(1)).getSpellNames();
    }

    @Test
    public void whenGetMagicalEntitiesIsCalledItShouldCallEntityCollectionGetMagicalEntitiesMethod() {
        controlWandService.getMagicalEntities();
        verify(entityCollection, times(1)).getMagicalEntities();
    }
}
