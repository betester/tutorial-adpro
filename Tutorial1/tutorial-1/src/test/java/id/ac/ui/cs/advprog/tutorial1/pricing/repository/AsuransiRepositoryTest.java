package id.ac.ui.cs.advprog.tutorial1.pricing.repository;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.AlphaAsuransi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsuransiRepositoryTest {

    private AsuransiRepositoryImpl asuransiRepository = new AsuransiRepositoryImpl();

    @Test
    public void testWhenFindByNameCalledReturnTheAsuransiObject() {

        asuransiRepository.addAsuransi("Alpha", new AlphaAsuransi(1000));

        assertEquals("Alpha", asuransiRepository.findByName("Alpha").getName());

    }
}
