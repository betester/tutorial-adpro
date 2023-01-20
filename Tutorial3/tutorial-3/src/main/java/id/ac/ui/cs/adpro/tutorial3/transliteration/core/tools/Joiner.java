package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import java.util.List;

/*
    given a list of spells, joins them into a large sentence
*/
public class Joiner {
    
    private Lingua usedLingua;

    public Joiner(Lingua lingua) {
        usedLingua = lingua;
    }

    public String join(List<Spell> spells) {
        
        StringBuilder ret = new StringBuilder("");
        char seperatingChar = usedLingua.getSeparatingChar();

        for(int temp=0;temp<spells.size();temp++) {
            ret.append(spells.get(temp).getText());
            if(temp != spells.size() - 1) {
                ret.append("" + seperatingChar);
            }
        }

        return ret.toString();
    }
}
