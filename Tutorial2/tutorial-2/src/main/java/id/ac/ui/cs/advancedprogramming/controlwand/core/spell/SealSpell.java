package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;

public class SealSpell implements Spell{
    private Familiar familiar;

    public SealSpell(Familiar familiar) {
        this.familiar = familiar;
    }

    @Override
    public void cast() {
        familiar.seal();
    }

    @Override
    public void undo() {
        familiar.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:SEAL",familiar.getName());
    }
}
