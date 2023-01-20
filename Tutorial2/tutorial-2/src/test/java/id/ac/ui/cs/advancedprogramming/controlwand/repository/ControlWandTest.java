package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.Spell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ControlWandTest {
    private Field spellListField;

    private ControlWand controlWand;


    @BeforeEach
    public void setUp() throws Exception {
        controlWand = new ControlWand();

        spellListField = ControlWand.class.getDeclaredField("spells");
        spellListField.setAccessible(true);
    }

    @Test
    public void whenRegisterSpellIsCalledItShouldStoreTheSpellInTheMap() throws Exception {
        Map spellsList;

        spellsList = (Map) spellListField.get(controlWand);
        assertEquals(0, spellsList.size());

        String spellName = "Fireball";
        Spell spell = Mockito.mock(Spell.class);
        when(spell.spellName()).thenReturn(spellName);

        controlWand.registerSpell(spell);

        spellsList = (Map) spellListField.get(controlWand);
        assertEquals(1, spellsList.size());
    }

    @Test
    public void whenCastIsCalledItShouldCastTheCorrectSpell() {
        String spellName = "Fireball";
        Spell spell = Mockito.mock(Spell.class);
        when(spell.spellName()).thenReturn(spellName);
        controlWand.registerSpell(spell);

        controlWand.cast(spellName);
        verify(spell, times(1)).cast();
    }

    @Test
    public void whenUndoIsCalledItShouldUndoTheCorrectSpell() {
        String spellName = "Fireball";
        Spell spell = Mockito.mock(Spell.class);
        when(spell.spellName()).thenReturn(spellName);
        controlWand.registerSpell(spell);
        controlWand.cast(spellName);
        controlWand.undo();
        verify(spell, times(1)).undo();
    }

    @Test
    public void whenGetSpellNamesItShouldReturnIterableOfAllSpellNamesStoredInSpellsMap() {
        String spellName = "Fireball";
        Spell spell = Mockito.mock(Spell.class);
        when(spell.spellName()).thenReturn(spellName);

        controlWand.registerSpell(spell);

        Iterable<String> spellNames = controlWand.getSpellNames();
        assertTrue(StreamSupport.stream(
                spellNames.spliterator(), false).anyMatch(spellName::equals));
    }

}
