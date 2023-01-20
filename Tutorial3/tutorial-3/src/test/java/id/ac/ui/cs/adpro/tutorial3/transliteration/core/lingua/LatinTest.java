package id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class LatinTest {

    @Test
    public void testLatinIsSingleton() {
        assertSame(Latin.getInstance(), Latin.getInstance());
    }
}
