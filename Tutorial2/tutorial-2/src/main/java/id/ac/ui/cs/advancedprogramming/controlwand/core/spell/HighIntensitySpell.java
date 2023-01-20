package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class HighIntensitySpell implements Spell{

    private MagicTool magicTool;

    public HighIntensitySpell(MagicTool magicTool) {
        this.magicTool = magicTool;
    }


    @Override
    public void cast() {
        magicTool.high();
    }

    @Override
    public void undo() {
        magicTool.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:HIGH",magicTool.getName());
    }
}
