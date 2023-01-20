package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

public class Familiar extends MagicalEntity {

    public Familiar(String name) {
        super(name);
        currentState = FamiliarState.SEALED;
    }

    @Override
    protected String defineState(MagicalEntityState state) {
        return this.name + " is " + state.toString();
    }

    public void seal() {
        currentState.seal(this);
    }

    public void summon() {
        currentState.summon(this);
    }

}
