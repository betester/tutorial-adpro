package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Lingua;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;

public class LinguaTranslator {

    /**
     * Melakukan substitusi monoalphabetic dari lingua satu ke lingua lainnya
     *
     * @param spell     : kalimat yang ingin di-transformasi
     * @param newLingua : jenis lingua baru yang diinginkan
     * @return hasil transformasi dalam bentuk String
     * @throws IllegalArgumentException saat Lingua lama dan Lingua baru tidak memiliki jumlah
     *                                  karakter yang sama
     */
    public static Spell translate(Spell spell, Lingua newLingua) throws IllegalArgumentException {
        String str = spell.getText();
        Lingua oldLingua = spell.getLingua();
        int n = str.length();
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            char oldChar = str.charAt(i);
            int charIdx = oldLingua.getIndex(oldChar);
            char newChar = newLingua.getChar(charIdx);
            res[i] = newChar;
        }
        return new Spell(new String(res), newLingua);
    }

}
