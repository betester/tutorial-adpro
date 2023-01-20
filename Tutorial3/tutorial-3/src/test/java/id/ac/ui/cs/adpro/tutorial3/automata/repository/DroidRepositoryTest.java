package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import static org.assertj.core.api.Assertions.assertThat;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.R2;
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
public class DroidRepositoryTest {
    private DroidRepository droidRepository;

    @Mock
    private Map<String, Droid> droids;

    private Droid sampleDroid;

    @BeforeEach
    public void setUp() {
        droidRepository = new DroidRepositoryImpl();
        droids = new HashMap<>();
        sampleDroid = new R2("D2");
        droids.put(sampleDroid.getName(), sampleDroid);
    }

    @Test
    public void whenDroidRepositoryFindAllShouldReturnDroidList() {
        ReflectionTestUtils.setField(droidRepository, "record", droids);
        List<Droid> acquiredDroid = droidRepository.findAll();
        assertThat(acquiredDroid).isEqualTo(new ArrayList<>(droids.values()));
    }

    @Test
    public void whenDroidRepoFindByNameItShouldReturnBowList() {
        ReflectionTestUtils.setField(droidRepository, "record", droids);
        Droid acquiredDroid = droidRepository.findByName(sampleDroid.getName());

        assertThat(acquiredDroid).isEqualTo(sampleDroid);
    }

    @Test
    public void whenDroidRepoAddShouldSaveDroid() {
        ReflectionTestUtils.setField(droidRepository, "record", droids);
        Droid r2 = new R2("D2");
        droidRepository.add(r2);
        Droid acquiredDroid = droidRepository.findByName(r2.getName());

        assertThat(acquiredDroid).isEqualTo(r2);
    }


}
