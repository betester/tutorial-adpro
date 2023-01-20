package id.ac.ui.cs.advancedprogramming.inventory.core;

public class RangedDummy extends Dummy{
    public RangedDummy(float weight, DummyType type, String weapon) {
        super(weight - (float) 0.2 * weight, type, weapon);
    }
}
