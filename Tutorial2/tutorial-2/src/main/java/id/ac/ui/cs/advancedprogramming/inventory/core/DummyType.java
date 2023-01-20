package id.ac.ui.cs.advancedprogramming.inventory.core;

public enum DummyType {
    MELEE(new MeleeDummyTemplate()),
    RANGED(new RangedDummyTemplate()),
    MAGIC(new MagicDummyTemplate());

    private DummyTypeTemplate template;

    DummyType(DummyTypeTemplate template) {
        this.template = template;
    }

    public void checkQuality(Dummy dummy) {
        template.checkQuality(dummy);
    }
}
