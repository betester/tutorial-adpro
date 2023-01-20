package id.ac.ui.cs.advancedprogramming.inventory.core;

public class MeleeDummyTemplate extends DummyTypeTemplate {
    @Override
    public void activateWeapon(Dummy dummy) {
//        do nothing
    }


    @Override
    public void attack(Dummy dummy) {
        dummy.getDummyLog().add(String.format("Dummy is attacking with %s",dummy.getWeapon()));
    }

    @Override
    public void defense(Dummy dummy) {
        dummy.getDummyLog().add("dummy is defending itself");
    }

    @Override
    public void buff(Dummy dummy) {
        dummy.getDummyLog().add("Dummy is using buff");
        attack(dummy);
    }
}
