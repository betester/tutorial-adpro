package id.ac.ui.cs.advancedprogramming.inventory.core;

public class MeleeDummy extends Dummy{
    public MeleeDummy(float weight, DummyType type, String weapon) {
        super(weight + 20, type, weapon);
    }
}
