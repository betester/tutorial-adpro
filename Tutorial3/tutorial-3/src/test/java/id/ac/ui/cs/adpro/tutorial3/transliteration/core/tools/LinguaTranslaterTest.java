package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import org.junit.jupiter.api.Test;

public class LinguaTranslaterTest {
    
    Lingua aeron = Aeron.getInstance();
    Lingua latin = Latin.getInstance();
    LinguaTranslator translator = new LinguaTranslator();

    @Test
    public void testAeronToLatin() {

        Spell aeronSpell = new Spell("bAMJXsXSx", aeron);
        Spell ret = translator.translate(aeronSpell, latin);

        assertEquals("hutaolove", ret.getText());
    }

    @Test
    public void testLatinToAeron() {
        Spell latinSpell = new Spell("hutaolove", latin);

        Spell ret = translator.translate(latinSpell, aeron);
        assertEquals("bAMJXsXSx", ret.getText());
    }
}
