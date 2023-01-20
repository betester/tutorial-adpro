package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

public interface Spell {
    //command
    public void cast();
    public void undo();
    public String spellName();
}
