package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import java.util.List;

public interface DroidRepository {

    List<Droid> findAll();

    Droid findByName(String name);

    void add(Droid droid);
}
