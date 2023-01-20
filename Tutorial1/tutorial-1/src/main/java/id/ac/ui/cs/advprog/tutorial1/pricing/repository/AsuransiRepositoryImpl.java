package id.ac.ui.cs.advprog.tutorial1.pricing.repository;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AsuransiRepositoryImpl implements AsuransiRepository {

    private Map<String, Asuransi> asuransis = new HashMap<>();

    @Override
    public void addAsuransi(String name, Asuransi a) {
        asuransis.put(name, a);
    }

    @Override
    public Asuransi findByName(String name) {
        return asuransis.get(name);
    }

}