package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;

/**
 * Kelas ini melakukan cipher Caesar
 */
public class Cipher  {

    private int key;

    public Cipher(int key) {
        this.key = key;
    }

    public Cipher() {
        this(13);
    }

    public Spell encode(Spell spell) {
        return process(spell, true);
    }

    public Spell decode(Spell spell) {
        return process(spell, false);
    }

    private Spell process(Spell spell, boolean encode) {
        String text = spell.getText();
        Lingua lingua = spell.getLingua();
        int linguaCharSize = lingua.getCharSize();
        int offset = encode ? key : linguaCharSize - key;
        char[] res = new char[text.length()];
        for (int i = 0; i < res.length; i++) {
            char oldChar = text.charAt(i);
            int charIdx = lingua.getIndex(oldChar);
            int newCharIdx = (charIdx + offset) % linguaCharSize;
            res[i] = lingua.getChar(newCharIdx);
        }

        return new Spell(new String(res), lingua);
    }
}
