package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class NoneIntensitySpell implements Spell{
    private MagicTool magicTool;

    public NoneIntensitySpell(MagicTool magicTool) {
        this.magicTool = magicTool;
    }

    @Override
    public void cast() {
        magicTool.off();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:NONE",magicTool.getName());
    }
}
