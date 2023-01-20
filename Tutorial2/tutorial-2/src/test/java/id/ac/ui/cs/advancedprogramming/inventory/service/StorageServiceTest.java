package id.ac.ui.cs.advancedprogramming.inventory.service;

import id.ac.ui.cs.advancedprogramming.inventory.core.DummyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorageServiceTest {
    private Class<?> storageService;

    @BeforeEach
    public void setUp() throws Exception {
        storageService = Class.forName("id.ac.ui.cs.advancedprogramming.inventory.service.StorageService");
    }

    @Test
    public void storageServiceShouldBeAPublicInterface() {
        int classModifiers = storageService.getModifiers();
        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void storageServiceShouldHaveGetDummiesAbstractMethod() throws Exception {
        Method getDummies = storageService.getDeclaredMethod("getDummies");
        int methodModifiers = getDummies.getModifiers();
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals(0, getDummies.getParameterCount());
    }

    @Test
    public void storageServiceShouldHaveGetDummyByIndexAbstractMethod() throws Exception {
        Method getDummy = storageService.getDeclaredMethod("getDummy", int.class);
        int methodModifiers = getDummy.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(1, getDummy.getParameterCount());
    }

    @Test
    public void storageServiceShouldHaveCreateDummyAbstractMethod() throws Exception {
        Method createDummy = storageService.getDeclaredMethod("createDummy", float.class,
                DummyType.class, String.class);
        int methodModifiers = createDummy.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(3, createDummy.getParameterCount());
    }

    @Test
    public void storageServiceShouldHaveRemoveDummyAbstractMethod() throws Exception {
        Method removeDummy = storageService.getDeclaredMethod("removeDummy", int.class);
        int methodModifiers = removeDummy.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(1, removeDummy.getParameterCount());
    }
}
