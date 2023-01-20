package id.ac.ui.cs.advancedprogramming.inventory.core;

public class MagicDummyTemplate extends DummyTypeTemplate {
    @Override
    public void activateWeapon(Dummy dummy) {
        dummy.getDummyLog().add(String.format("Activating %s",dummy.getWeapon()));
    }

    @Override
    public void attack(Dummy dummy) {
        dummy.getDummyLog().add(String.format("Dummy is attacking with %s",dummy.getWeapon()));
        buff(dummy);
    }

    @Override
    public void defense(Dummy dummy) {
        dummy.getDummyLog().add("dummy is defending itself");
    }

    @Override
    public void buff(Dummy dummy) {
        dummy.getDummyLog().add("Dummy is using buff");
    }
}
