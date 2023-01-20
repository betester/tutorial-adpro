package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class LowIntensitySpell implements Spell{
    private MagicTool magicTool;

    public LowIntensitySpell(MagicTool magicTool) {
        this.magicTool = magicTool;
    }


    @Override
    public void cast() {
        magicTool.low();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:LOW",magicTool.getName());
    }
}
