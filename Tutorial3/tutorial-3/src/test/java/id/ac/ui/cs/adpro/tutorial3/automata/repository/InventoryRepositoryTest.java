package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

@Repository
public class InventoryRepositoryTest {
    private InventoryRepository inventoryRepository;

    @Mock
    private List<String> inventory;

    @BeforeEach
    public void setUp(){
        inventoryRepository = new InventoryRepositoryImpl();
        inventory = new ArrayList<>();
        inventory.add("Box");
    }

    @Test
    public void whenInventoryRepositoryFetchInventoryItShouldGetAllInventory() {
        ReflectionTestUtils.setField(inventoryRepository, "inventory", inventory);
        List<String> acquiredInventory = inventoryRepository.fetchInventory();
        assertThat(acquiredInventory).isEqualTo(inventory);
    }

    @Test
    public void whenInventoryRepositoryAddItemItShouldSaveIt() {
        ReflectionTestUtils.setField(inventoryRepository, "inventory", inventory);
        inventoryRepository.addItem("Spear");
        List<String> acquiredInventory = inventoryRepository.fetchInventory();

        assertThat(acquiredInventory).isEqualTo(inventory);
        assertThat(inventory.get(1)).isEqualTo("Spear");
    }
}
