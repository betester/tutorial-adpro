package id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;


public class AeronTest {

    @Test
    public void testAeronIsSingleton() {
        assertSame(Aeron.getInstance(), Aeron.getInstance());
    }
}
