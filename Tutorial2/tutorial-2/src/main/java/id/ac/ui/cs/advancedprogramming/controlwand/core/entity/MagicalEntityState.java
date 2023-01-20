package id.ac.ui.cs.advancedprogramming.controlwand.core.entity;

public interface MagicalEntityState {
    public void seal(MagicalEntity familiar);
    public void summon(MagicalEntity familiar);
    public void off(MagicalEntity magicTool);
    public void low(MagicalEntity magicTool);
    public void medium(MagicalEntity magicTool);
    public void high(MagicalEntity magicTool);

}
