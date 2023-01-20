package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import java.util.List;

public interface FluidsRepository {

    List<Fluids> findAll();

    Fluids findByName(String name);

    void add(Fluids fluids);
}
