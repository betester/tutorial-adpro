package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

public class MagicTool extends MagicalEntity {

    public MagicTool(String name) {
        super(name);
        currentState = ManaIntensity.NONE;
    }

    @Override
    protected String defineState(MagicalEntityState state) {
        return this.name + "'s mana intensity has been set to " + state.toString();
    }

    public void off() {
        // TODO: Complete Me
        currentState.off(this);
    }

    public void low() {
        // TODO: Complete Me
        currentState.low(this);

    }

    public void medium() {
        // TODO: Complete Me
        currentState.medium(this);

    }

    public void high() {
        // TODO: Complete Me
        currentState.high(this);

    }
}
