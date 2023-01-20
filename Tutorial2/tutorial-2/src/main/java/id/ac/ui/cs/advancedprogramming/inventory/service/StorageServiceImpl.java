package id.ac.ui.cs.advancedprogramming.inventory.service;

import id.ac.ui.cs.advancedprogramming.inventory.core.Dummy;
import id.ac.ui.cs.advancedprogramming.inventory.core.DummyType;
import id.ac.ui.cs.advancedprogramming.inventory.repository.DummyStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    private final DummyStorage repository;

    public StorageServiceImpl(DummyStorage repository) {
        this.repository = repository;
    }

    @Override
    public List<Dummy> getDummies() {
        return repository.getDummies();
    }

    @Override
    public Dummy getDummy(int index) {
        return repository.getDummy(index);
    }

    @Override
    public void createDummy(float weight, DummyType type, String weapon) {
        repository.createDummy(weight,type,weapon);
    }

    @Override
    public void removeDummy(int index) {
        repository.removeDummy(index);
    }
}
