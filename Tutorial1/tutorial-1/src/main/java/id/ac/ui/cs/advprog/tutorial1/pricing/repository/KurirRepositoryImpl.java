package id.ac.ui.cs.advprog.tutorial1.pricing.repository;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class KurirRepositoryImpl implements KurirRepository {

    private Map<String, Kurir> kurirs = new HashMap<>();

    @Override
    public void addKurir(String name, Kurir a) {
        kurirs.put(name, a);
    }

    @Override
    public Kurir findByName(String name) {
        return kurirs.get(name);
    }

}