package id.ac.ui.cs.advprog.tutorial1.pricing.repository;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;

public interface KurirRepository {

    void addKurir(String name, Kurir a);
    Kurir findByName(String name);
}
