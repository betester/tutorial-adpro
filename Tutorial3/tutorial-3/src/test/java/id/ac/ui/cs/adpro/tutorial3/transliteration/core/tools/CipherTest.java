package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import org.junit.jupiter.api.Test;

public class CipherTest {
    
    Cipher cipher3 = new Cipher(3);
    Lingua latin = Latin.getInstance();

    @Test
    public void testCipherEncode() {

        Spell s = new Spell("mobiusx", latin);
        Spell ret = cipher3.encode(s);

        assertEquals("prelxv.", ret.getText());

    }

    @Test
    public void testCipherDecode() {
        Spell s = new Spell("prelxv.", latin);
        Spell ret = cipher3.decode(s);

        assertEquals("mobiusx", ret.getText());
    }
}
