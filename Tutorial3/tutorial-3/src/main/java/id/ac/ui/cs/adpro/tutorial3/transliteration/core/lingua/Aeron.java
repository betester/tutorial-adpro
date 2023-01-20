package id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua;

public class Aeron extends Lingua {

    private static final char[] CHARS = {
        '_', ')', '!', '@', '#', '$', '%', '^', '&', '*', '(',
        '{', '}', '[', ']', '|', ':', ';', ',', '.', '<', '>', '?', '/',
        '=', '-', '+', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
        'J', 'K', 'L', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'a', 's', 'd',
        'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'A', 'S', 'D', 'F', 'G', 'H'
    };
    private static Aeron self = null;

    private Aeron() {
        super(CHARS);
    }

    public static Aeron getInstance() {
        if (self == null) {
            self = new Aeron();
        }

        return self;
    }

    public char getSeparatingChar() {
        return '0';
    }
}
