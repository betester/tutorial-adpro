package id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua;

public class Latin extends Lingua {

    private static final char[] CHARS = {
        '.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private static Latin self = null;

    private Latin() {
        super(CHARS);
    }

    public static Latin getInstance() {
        if (self == null) {
            self = new Latin();
        }

        return self;
    }

    public char getSeparatingChar() {
        return ' ';
    }
}