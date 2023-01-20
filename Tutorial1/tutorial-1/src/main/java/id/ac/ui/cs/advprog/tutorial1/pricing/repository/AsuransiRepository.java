package id.ac.ui.cs.advprog.tutorial1.pricing.repository;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;

public interface AsuransiRepository {

    void addAsuransi(String name, Asuransi a);
    Asuransi findByName(String name);
}
