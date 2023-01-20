package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.List;

public interface InventoryRepository {

    List<String> fetchInventory();

    void addItem(String item);
}
