package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Parses a long string of a Lingua and return list of spells in that Lingua
*/
public class Parser {
    
    private Lingua parsedLingua;

    public Parser(Lingua lingua) {
        parsedLingua = lingua;
    }

    public List<Spell> parseSentence(String sentence) {
       ArrayList<Spell> spells = new ArrayList<>(); 
    
       char seperatingChar = parsedLingua.getSeparatingChar();

       List<String> parsed = Arrays.asList(sentence.split(""+seperatingChar));
       for(String p: parsed) {
        spells.add(new Spell(p, parsedLingua));
       }

       return spells;
    }
}
