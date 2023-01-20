package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import static org.assertj.core.api.Assertions.assertThat;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Slime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

@Repository
public class FluidsRepositoryTest {
    private FluidsRepository fluidsRepository;

    @Mock
    private Map<String, Fluids> fluids;

    private Fluids sampleFluids;

    @BeforeEach
    public void setUp() {
        fluidsRepository = new FluidsRepositoryImpl();
        fluids = new HashMap<>();
        sampleFluids = new Slime("Rimuru");
        fluids.put(sampleFluids.getName(), sampleFluids);
    }

    @Test
    public void whenFluidsRepositoryFindAllShouldReturnDroidList() {
        ReflectionTestUtils.setField(fluidsRepository, "record", fluids);
        List<Fluids> acquiredFluids = fluidsRepository.findAll();
        assertThat(acquiredFluids).isEqualTo(new ArrayList<>(fluids.values()));
    }

    @Test
    public void whenFluidsRepoFindByNameItShouldReturnBowList() {
        ReflectionTestUtils.setField(fluidsRepository, "record", fluids);
        Fluids acquiredFluids = fluidsRepository.findByName(sampleFluids.getName());

        assertThat(acquiredFluids).isEqualTo(sampleFluids);
    }

    @Test
    public void whenFluidsRepoAddShouldSaveDroid() {
        ReflectionTestUtils.setField(fluidsRepository, "record", fluids);
        Fluids rimuru = new Slime("Tempest");
        fluidsRepository.add(rimuru);
        Fluids acquiredFluids = fluidsRepository.findByName(rimuru.getName());

        assertThat(acquiredFluids).isEqualTo(rimuru);
    }


}
