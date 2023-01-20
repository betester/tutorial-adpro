package id.ac.ui.cs.advancedprogramming.controlwand.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlWandServiceTest {
    private Class<?> controlWandService;

    @BeforeEach
    public void setUp() throws Exception {
        controlWandService = Class.forName("id.ac.ui.cs.advancedprogramming.controlwand.service.ControlWandService");
    }

    @Test
    public void controlWandServiceShouldBeAPublicInterface() {
        int classModifiers = controlWandService.getModifiers();
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void controlWandServiceShouldHaveCastSpellAbstractMethod() throws Exception {
        Method castSpell = controlWandService.getDeclaredMethod("castSpell", String.class);
        int methodModifier = castSpell.getModifiers();
        assertTrue(Modifier.isAbstract(methodModifier));
        assertTrue(Modifier.isPublic(methodModifier));
        assertEquals(1, castSpell.getParameterCount());
    }

    @Test
    public void controlWandServiceShouldHaveUndoSpellAbstractMethod() throws Exception {
        Method undoSpell = controlWandService.getDeclaredMethod("undoSpell");
        int methodModifier = undoSpell.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(0, undoSpell.getParameterCount());
    }

    @Test
    public void controllerWandServiceShouldHaveGetSpellNamesAbstractMethod() throws Exception {
        Method getSpellNames = controlWandService.getDeclaredMethod("getSpellNames");
        int methodModifier = getSpellNames.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(0, getSpellNames.getParameterCount());
    }

    @Test
    public void controllerWandServiceShouldHaveGetMagicalEntitiesAbstractMethod() throws Exception {
        Method getMagicalEntities = controlWandService.getDeclaredMethod("getMagicalEntities");
        int methodModifier = getMagicalEntities.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(0, getMagicalEntities.getParameterCount());
    }

    @Test
    public void controlWandServiceShouldHaveContractFamiliarAbstractMethod() throws Exception {
        Method contractFamiliar = controlWandService.getDeclaredMethod("contractFamiliar", String.class);
        int methodModifier = contractFamiliar.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(1, contractFamiliar.getParameterCount());
    }

    @Test
    public void controlWandServiceShouldHaveBuyMagicToolAbstractMethod() throws Exception {
        Method buyMagicTool = controlWandService.getDeclaredMethod(
                "buyMagicTool",
                String.class,
                EnumSet.class
        );
        int methodModifier = buyMagicTool.getModifiers();
        assertTrue(Modifier.isPublic(methodModifier));
        assertTrue(Modifier.isAbstract(methodModifier));
        assertEquals(2, buyMagicTool.getParameterCount());
    }
}
