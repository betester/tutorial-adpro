package id.ac.ui.cs.advancedprogramming.inventory.core;

public class RangedDummyTemplate extends DummyTypeTemplate {
    @Override
    public void activateWeapon(Dummy dummy) {
        dummy.getDummyLog().add(String.format("Activating %s",dummy.getWeapon()));
    }

    @Override
    public void attack(Dummy dummy) {
        dummy.getDummyLog().add(String.format("Dummy is attacking with %s",dummy.getWeapon()));
    }

    @Override
    public void defense(Dummy dummy) {
        //do nothing
    }

    @Override
    public void buff(Dummy dummy) {
        dummy.getDummyLog().add("Dummy is using buff");
    }
}
