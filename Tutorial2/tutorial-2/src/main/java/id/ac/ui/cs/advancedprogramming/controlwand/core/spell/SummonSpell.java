package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.FamiliarState;

public class SummonSpell implements Spell{
    private Familiar familiar;

    public SummonSpell(Familiar familiar){
        this.familiar = familiar;
    }

    @Override
    public void cast() {
            this.familiar.summon();
    }

    @Override
    public void undo() {
        this.familiar.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:SUMMONED",familiar.getName());
    }
}
