package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class FluidsRepositoryImpl implements FluidsRepository {

    private Map<String, Fluids> record = new HashMap<>();

    @Override
    public List<Fluids> findAll() {
        return new ArrayList<>(record.values());
    }

    @Override
    public Fluids findByName(String name) {
        return record.get(name);
    }

    @Override
    public void add(Fluids fluids) {
        String name = fluids.getName();
        record.put(name, fluids);
    }
}
