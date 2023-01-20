package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class DroidRepositoryImpl implements DroidRepository {

    private Map<String, Droid> record = new HashMap<>();

    @Override
    public List<Droid> findAll() {
        return new ArrayList<>(record.values());
    }

    @Override
    public Droid findByName(String name) {
        return record.get(name);
    }

    @Override
    public void add(Droid droid) {
        String name = droid.getName();
        record.put(name, droid);
    }
}
