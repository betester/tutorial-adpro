package id.ac.ui.cs.advancedprogramming.inventory.core;

import java.util.List;

public abstract class DummyTypeTemplate {
    public void checkQuality(Dummy dummy) {
        activateDummy(dummy);
        activateWeapon(dummy);
        attack(dummy);
        attack(dummy);
        buff(dummy);
        attack(dummy);
        defense(dummy);
        attack(dummy);
        defense(dummy);
        deactivateDummy(dummy);
    }

    public void activateDummy(Dummy dummy) {
        dummy.getDummyLog().add("Activate dummy");
    }
    public abstract void activateWeapon(Dummy dummy);
    public void deactivateDummy(Dummy dummy) {
        dummy.getDummyLog().add("Deactivate");
    }
    public abstract void attack(Dummy dummy);
    public abstract void defense(Dummy dummy);
    public  abstract void buff(Dummy dummy);
}
