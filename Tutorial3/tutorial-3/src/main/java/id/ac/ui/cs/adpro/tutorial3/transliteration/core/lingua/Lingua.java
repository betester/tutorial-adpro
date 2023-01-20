package id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua;

import java.util.Map;
import java.util.TreeMap;

public abstract class Lingua {

    private char[] charArr;
    private Map<Character, Integer> reverseIndex;

    protected Lingua(char[] charArr, Map<Character, Integer> reverseIndex) {
        this.charArr = charArr;
        this.reverseIndex = reverseIndex;
    }

    protected Lingua(char[] charArr) {
        this(charArr, new TreeMap<>());
        initReverseIndex();
    }

    private void initReverseIndex() {
        for (int i = 0; i < charArr.length; i++) {
            reverseIndex.put(charArr[i], i);
        }
    }

    public char[] getCharacters() {
        return charArr;
    }

    public int getCharSize() {
        return charArr.length;
    }

    public Map<Character, Integer> getReverseIndex() {
        return reverseIndex;
    }

    public int getIndex(char ch) {
        return reverseIndex.getOrDefault(ch, -1);
    }

    public char getChar(int i) {
        return charArr[i];
    }

    abstract public char getSeparatingChar();
}
