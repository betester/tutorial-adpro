package id.ac.ui.cs.adpro.tutorial3.automata;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Gemini;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.R2;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.T800;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Slime;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Symbiote;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.IronGolem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.SnowGolem;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.DroidRepository;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.FluidsRepository;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.GolemRepository;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.InventoryRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutomataInitializer {

    @Autowired
    private DroidRepository droidRepository;

    @Autowired
    private FluidsRepository fluidsRepository;

    @Autowired
    private GolemRepository golemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @PostConstruct
    public void init() {
        droidRepository.add(new Gemini("Inquisitor"));
        droidRepository.add(new R2("D2"));
        droidRepository.add(new T800("Terminator"));
        fluidsRepository.add(new Slime("Geo"));
        fluidsRepository.add(new Symbiote("Carnage"));
        golemRepository.add(new IronGolem("Dinnerbone"));
        golemRepository.add(new SnowGolem("Joergen"));
        inventoryRepository.addItem("Trident");
        inventoryRepository.addItem("Netherite Sword");
        inventoryRepository.addItem("Netherite Pickaxe");
        inventoryRepository.addItem("Netherite Pickaxe");
        inventoryRepository.addItem("Netherite Pickaxe");
        inventoryRepository.addItem("Netherite Pickaxe");
        inventoryRepository.addItem("Enchanted Crossbow");
        inventoryRepository.addItem("Enchanted Crossbow");
        inventoryRepository.addItem("Fireball");
        inventoryRepository.addItem("Fireball");
        inventoryRepository.addItem("Fireball");
        inventoryRepository.addItem("TNT");
        inventoryRepository.addItem("TNT");
        inventoryRepository.addItem("TNT");
        inventoryRepository.addItem("Enchanted Bow");
        inventoryRepository.addItem("Enchanted Bow");
        inventoryRepository.addItem("Arrow");
    }
}
