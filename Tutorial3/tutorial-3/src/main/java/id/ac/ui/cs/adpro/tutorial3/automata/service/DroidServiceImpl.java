package id.ac.ui.cs.adpro.tutorial3.automata.service;

import id.ac.ui.cs.adpro.tutorial3.automata.core.adapter.FluidAdapter;
import id.ac.ui.cs.adpro.tutorial3.automata.core.adapter.GolemAdapter;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Slime;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroidServiceImpl implements DroidService {
    @Autowired
    private DroidRepository droidRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private GolemRepository golemRepository;
    @Autowired
    private FluidsRepository fluidsRepository;
    @Autowired
    private LoggerRepository loggerRepository;
    private List<Droid> units;

    /**
     * Mengambil seluruh droid yang tersimpan.
     * Note: Termasuk seluruh automata pengganti droid.
     *
     * @return List automata
     */
    public DroidServiceImpl() {
    }

    @Override
    public List<Droid> fetchDroids() {
        // TODO: Complete this method
        List<Droid> droids = new ArrayList<>();
        List<Droid> adaptedFluids = fluidsRepository.findAll().stream().map(FluidAdapter::new).collect(Collectors.toList());
        List<Droid> adaptedGolems = golemRepository.findAll().stream().map(GolemAdapter::new).collect(Collectors.toList());
        droids.addAll(droidRepository.findAll());
        droids.addAll(adaptedFluids);
        droids.addAll(adaptedGolems);
        return droids;
    }

    /**
     * Mengambil seluruh rekaman inventory yang tersimpan.
     *
     * @return List rekaman inventory
     */
    @Override
    public List<String> fetchInventories() {
        // TODO: Complete this method
        return inventoryRepository.fetchInventory();
    }

    /**
     * Menambahkan sebuah benda ke dalam inventory.
     *
     * @param item benda untuk ditambah
     */
    @Override
    public void addInventory(String item) {
        inventoryRepository.addItem(item);
        // TODO: Complete this method
    }

    /**
     * Mengambil seluruh rekaman log yang tersimpan.
     *
     * @return List rekaman log
     */
    @Override
    public List<String> fetchLogs() {
        // TODO: Complete this method
        return loggerRepository.getLogs();
    }

    /**
     * Memanggil droid untuk melakukan sebuah rutinitas.
     *
     * @param droidName droid yang ingin dipanggil
     * @param routine   rutinitas yang akan dilakukan droid
     */
    @Override
    public void doRoutine(String droidName, int routine) {

        // TODO: Complete this method
        Droid droid1 = null;

        for (Droid droid : fetchDroids()) {
            if (droid.getName().equals(droidName)) {
                droid1 = droid;
                break;
            }
        }

        List<String> inventory = inventoryRepository.fetchInventory();
        Set<String> usedInventory = new HashSet<>();

        switch (routine) {
            case 0:
                for (String item : inventory) {
                    if (!usedInventory.contains(item)  && droid1 != null) {
                        recordLog(droid1, droid1.liftItem(item));
                    }
                    usedInventory.add(item);
                }

                break;
            case 1:
                for (String item : inventory) {
                    if (!usedInventory.contains(item) && droid1 != null) {
                        recordLog(droid1, droid1.countItem(inventory,item));
                    }
                    usedInventory.add(item);
                }
                break;
            case 2:
                if ( droid1 != null)
                recordLog(droid1,droid1.useTransporter());
                break;
            case 3:
                if (  droid1 != null)
                recordLog(droid1, droid1.useCrane());
                break;
        }

    }

    /**
     * Rekam sebuah Log dengan format: "<Nama droid>: <Aksi droid>"
     *
     * @param droid  Droid yang melakukan aksi
     * @param action Aksi yang dilakukan droid
     */
    protected void recordLog(Droid droid, String action) {
        // TODO: Complete this method
        loggerRepository.addRecord(String.format("%s:%s",droid.getName(),action));
    }
}
