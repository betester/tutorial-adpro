package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import org.junit.jupiter.api.Test;

public class ShifterTest {
    
    Shifter shifter = new Shifter();
    Lingua lingua = Aeron.getInstance();

    @Test
    public void TestShifterFourWork() {

        Spell s = new Spell("yugiohmaster", lingua);
        Spell ret = shifter.shift(s, 4);

        assertEquals("steryugiohma", ret.getText());
        
    }

    @Test
    public void TestShifterNegativeWork() {
        Spell s = new Spell("steryugiohma", lingua);
        Spell ret = shifter.shift(s, -4);

        assertEquals("yugiohmaster", ret.getText());
    }

    @Test
    public void TestShifterOverLenWork() {
        Spell s = new Spell("yugioh", lingua);
        Spell ret = shifter.shift(s, 8);

        assertEquals("ohyugi", ret.getText());
    }
}
