package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import static org.assertj.core.api.Assertions.assertThat;

import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.IronGolem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.SnowGolem;
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
public class GolemRepositoryTest {
    private GolemRepository golemRepository;

    @Mock
    private Map<String, Golem> golems;

    private Golem sampleGolem;

    @BeforeEach
    public void setUp() {
        golemRepository = new GolemRepositoryImpl();
        golems = new HashMap<>();
        sampleGolem = new SnowGolem("Ganyu");
        golems.put(sampleGolem.getName(), sampleGolem);
    }

    @Test
    public void whenGolemRepositoryFindAllShouldReturnDroidList() {
        ReflectionTestUtils.setField(golemRepository, "record", golems);
        List<Golem> acquiredGolems = golemRepository.findAll();
        assertThat(acquiredGolems).isEqualTo(new ArrayList<>(golems.values()));
    }

    @Test
    public void whenGolemRepoFindByNameItShouldReturnBowList() {
        ReflectionTestUtils.setField(golemRepository, "record", golems);
        Golem acquiredGolems = golemRepository.findByName(sampleGolem.getName());

        assertThat(acquiredGolems).isEqualTo(sampleGolem);
    }

    @Test
    public void whenGolemRepoAddShouldSaveDroid() {
        ReflectionTestUtils.setField(golemRepository, "record", golems);
        Golem shenshe = new IronGolem("shenshe");
        golemRepository.add(shenshe);
        Golem acquiredGolems = golemRepository.findByName(shenshe.getName());

        assertThat(acquiredGolems).isEqualTo(shenshe);
    }
}
