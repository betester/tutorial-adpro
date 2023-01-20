package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class MediumIntensitySpell implements Spell{
    private MagicTool magicTool;

    public MediumIntensitySpell(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public void cast() {
        magicTool.medium();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:MEDIUM",magicTool.getName());
    }
}
