package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import java.util.List;

public interface GolemRepository {

    List<Golem> findAll();

    Golem findByName(String name);

    void add(Golem golem);
}
