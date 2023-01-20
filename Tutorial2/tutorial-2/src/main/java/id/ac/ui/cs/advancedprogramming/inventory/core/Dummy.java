package id.ac.ui.cs.advancedprogramming.inventory.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Dummy {
    protected DummyType type;
    protected String weapon;
    protected List<String> dummyLog;
    protected float weight;

    public Dummy(float weight, DummyType type, String weapon) {
        this.weight = weight;
        this.type = type;
        this.weapon = weapon;
        dummyLog = new ArrayList<>();
        qualityCheck();
    }

    public DummyType getType() {
        return type;
    }

    public String getWeapon() {
        return weapon;
    }

    public float getWeight() {
        return weight;
    }

    public List<String> getDummyLog() {
        return dummyLog;
    }

    public void qualityCheck() {
        // TODO: Complete Me
        type.checkQuality(this);
    }
}
