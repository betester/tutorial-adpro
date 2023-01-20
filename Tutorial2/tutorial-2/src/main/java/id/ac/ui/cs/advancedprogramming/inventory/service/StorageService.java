package id.ac.ui.cs.advancedprogramming.inventory.service;

import id.ac.ui.cs.advancedprogramming.inventory.core.Dummy;
import id.ac.ui.cs.advancedprogramming.inventory.core.DummyType;

import java.util.List;

public interface StorageService {
    public List<Dummy> getDummies();
    public Dummy getDummy(int index);
    public void createDummy(float weight, DummyType type, String weapon);
    public void removeDummy(int index);
}
