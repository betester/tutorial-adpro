package id.ac.ui.cs.adpro.tutorial3.transliteration.core.util;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;

public class Spell {

    private String text;
    private Lingua lingua;

    public Spell(String text, Lingua lingua) {
        this.text = text;
        this.lingua = lingua;
    }

    public String getText() {
        return text;
    }

    public Lingua getLingua() {
        return lingua;
    }
}
