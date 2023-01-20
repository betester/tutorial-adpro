package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class GolemRepositoryImpl implements GolemRepository {

    private Map<String, Golem> record = new HashMap<>();

    @Override
    public List<Golem> findAll() {
        return new ArrayList<>(record.values());
    }

    @Override
    public Golem findByName(String name) {
        return record.get(name);
    }

    @Override
    public void add(Golem golem) {
        String name = golem.getName();
        record.put(name, golem);
    }
}
