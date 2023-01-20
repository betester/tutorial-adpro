package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    private List<String> inventory = new ArrayList<>();

    @Override
    public List<String> fetchInventory() {
        return inventory;
    }

    @Override
    public void addItem(String item) {
        inventory.add(item);
    }
}
