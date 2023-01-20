package id.ac.ui.cs.advancedprogramming.controlwand.core.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MagicalEntityStateTest {
    private Class<?> magicalEntityStateClass;

    @BeforeEach
    public void setUp() throws Exception {
        magicalEntityStateClass = Class
                .forName("id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState");
    }

    @Test
    public void magicalEntityStateIsAPublicInterface() {
        int classModifiers = magicalEntityStateClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }
}
