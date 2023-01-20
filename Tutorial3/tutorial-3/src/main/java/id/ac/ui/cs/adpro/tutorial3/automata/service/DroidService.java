package id.ac.ui.cs.adpro.tutorial3.automata.service;


import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import java.util.List;

public interface DroidService {

    List<Droid> fetchDroids();

    List<String> fetchInventories();

    void addInventory(String item);

    List<String> fetchLogs();

    void doRoutine(String droidName, int routine);
}
