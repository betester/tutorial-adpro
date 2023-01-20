package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JoinerTest {
    
    Joiner aeronJoiner = new Joiner(Aeron.getInstance());
    Lingua lingua = Aeron.getInstance();

    @Test
    public void testJoinerOneSenteceWorks() {
        List<Spell> words = new ArrayList<>();
        
        words.add(new Spell("%^&*(", lingua));

        String ret = aeronJoiner.join(words);
        assertEquals("%^&*(", ret);
    }

    @Test
    public void testJoinerTwoSentenceWorks() {
        List<Spell> words = new ArrayList<>();
        
        words.add(new Spell("%^&*(", lingua));
        words.add(new Spell("%++*(", lingua));

        String ret = aeronJoiner.join(words);
        assertEquals("%^&*(0%++*(", ret);
    }

    @Test
    public void testJoinerManySentenceWorks() {
        List<Spell> words = new ArrayList<>();
        
        words.add(new Spell("%^&*(", lingua));
        words.add(new Spell("%++*(", lingua));
        words.add(new Spell("%##)", lingua));
        words.add(new Spell("%)()", lingua));

        String ret = aeronJoiner.join(words);
        assertEquals("%^&*(0%++*(0%##)0%)()", ret);
    }
}