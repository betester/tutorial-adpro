package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpellTest {
    private Class<?> spell;

    @BeforeEach
    public void setUp() throws Exception {
        spell = Class.forName("id.ac.ui.cs.advancedprogramming.controlwand.core.spell.Spell");
    }

    @Test
    public void spellShouldBeAPublicInterface() {
        int classModifiers = spell.getModifiers();
        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isAbstract(classModifiers));
    }

    @Test
    public void spellInterfaceShouldHaveAbstractCastMethod() throws Exception {
        Method cast = spell.getDeclaredMethod("cast");
        int methodModifier = cast.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(0, cast.getParameterCount());
    }

    @Test
    public void spellInterfaceShouldHaveAbstractUndoMethod() throws Exception {
        Method undo = spell.getDeclaredMethod("undo");
        int methodModifier = undo.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(0, undo.getParameterCount());
    }

    @Test
    public void spellInterfaceShouldHaveAbstractSpellNameMethod() throws Exception {
        Method spellName = spell.getDeclaredMethod("spellName");
        int methodModifier = spellName.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(0, spellName.getParameterCount());
    }
}
