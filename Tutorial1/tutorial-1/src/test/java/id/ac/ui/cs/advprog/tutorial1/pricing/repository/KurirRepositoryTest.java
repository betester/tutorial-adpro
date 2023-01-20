package id.ac.ui.cs.advprog.tutorial1.pricing.repository;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.KudaKurir;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KurirRepositoryTest {

    private KurirRepositoryImpl kurirRepository = new KurirRepositoryImpl();

    @Test
    public void testWhenFindByNameCalledReturnTheKurirObject() {

        kurirRepository.addKurir("Kuda", new KudaKurir(50));

        assertEquals("Kuda", kurirRepository.findByName("Kuda").getName());

    }
}
