package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ParserTest {
    

    @Test
    public void TestLatinParserIsCorrect() {
        Parser latinParser = new Parser(Latin.getInstance());

        String sentence = "aku makan pagi";
        List<Spell> spells = latinParser.parseSentence(sentence);

        assertEquals(3, spells.size());
        assertEquals("aku", spells.get(0).getText());
        assertEquals("makan", spells.get(1).getText());
        assertEquals("pagi", spells.get(2).getText());
        
    }

    @Test
    public void TestAeronParserIsCorrect() {
        Parser latinParser = new Parser(Aeron.getInstance());

        String sentence = "!@#0*()$0:@@@";
        List<Spell> spells = latinParser.parseSentence(sentence);

        assertEquals(3, spells.size());
        assertEquals("!@#", spells.get(0).getText());
        assertEquals("*()$", spells.get(1).getText());
        assertEquals(":@@@", spells.get(2).getText());
    }
}
