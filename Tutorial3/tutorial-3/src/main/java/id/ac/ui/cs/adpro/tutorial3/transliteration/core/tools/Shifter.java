package id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools;

import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;

/*
    tool to shift string length 'shiftNumber' to the right
*/
public class Shifter {
    
    public Spell shift(Spell spell, int shiftNumber) {

        String text = spell.getText();
        int len = text.length();


        shiftNumber = shiftNumber%len;
        if(shiftNumber < 0) shiftNumber += len;

        StringBuilder newStr = new StringBuilder(text);
        for(int temp=0;temp<len;temp++) {
            int newIndex = (temp + shiftNumber)%len;

            newStr.setCharAt(newIndex, text.charAt(temp));
        }

        return new Spell(newStr.toString(), spell.getLingua());
    }
}
