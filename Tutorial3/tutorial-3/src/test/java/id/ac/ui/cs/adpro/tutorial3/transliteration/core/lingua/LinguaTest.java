package id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;


public class LinguaTest {

    private Class<?> linguaClass;
    private Lingua lingua;

    @Mock
    private char[] charArr;

    @Mock
    private Map<Character, Integer> reverseIndex;

    @BeforeEach
    public void setUp() throws Exception {
        charArr = new char[] {'a', 'b'};
        reverseIndex = new HashMap<>();
        reverseIndex.put('a', 0);
        reverseIndex.put('b', 1);

        linguaClass = Class.forName(
            "id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua");
        lingua = (Lingua) Mockito.mock(linguaClass, Mockito.CALLS_REAL_METHODS);
        ReflectionTestUtils.setField(lingua, "charArr", charArr);
        ReflectionTestUtils.setField(lingua, "reverseIndex", reverseIndex);
    }

    @Test
    public void testLinguaIsPublicAbstractClass() {
        assertTrue(Modifier.isPublic(linguaClass.getModifiers()));
        assertTrue(Modifier.isAbstract(linguaClass.getModifiers()));
    }

    @Test
    public void testLinguaGetCharactersMethod() throws Exception {
        Method getCharacter = linguaClass.getDeclaredMethod("getCharacters");
        assertTrue(Modifier.isPublic(getCharacter.getModifiers()));
    }

    @Test
    public void testLinguaGetCharacterReturnCharArr() {
        assertEquals(charArr, lingua.getCharacters());
    }

    @Test
    public void testLinguaGetCharSizeMethod() throws Exception {
        Method getCharSize = linguaClass.getDeclaredMethod("getCharSize");
        assertTrue(Modifier.isPublic(getCharSize.getModifiers()));
    }

    @Test
    public void testLinguaGetCharSizeReturnCharArrSize() {
        assertEquals(charArr.length, lingua.getCharSize());
    }

    @Test
    public void testLinguaGetReverseIndexMethod() throws Exception {
        Method getReverseIndex = linguaClass.getDeclaredMethod("getReverseIndex");
        assertTrue(Modifier.isPublic(getReverseIndex.getModifiers()));
    }

    @Test
    public void testLinguaGetReverseIndexReturnReverseIndex() {
        assertEquals(reverseIndex, lingua.getReverseIndex());
    }

    @Test
    public void testLinguaGetIndexMethod() throws Exception {
        Method getIndex = linguaClass.getDeclaredMethod("getIndex", char.class);
        assertTrue(Modifier.isPublic(getIndex.getModifiers()));
    }

    @Test
    public void testLinguaGetIndexReturnCharAtIndex() {
        assertEquals(0, lingua.getIndex('a'));
    }

    @Test
    public void testLinguaGetCharMethod() throws Exception {
        Method getChar = linguaClass.getDeclaredMethod("getChar", int.class);
        assertTrue(Modifier.isPublic(getChar.getModifiers()));
    }

    @Test
    public void testLinguaGetCharReturnCharAtIndex() {
        assertEquals('a', lingua.getChar(0));
    }
}
