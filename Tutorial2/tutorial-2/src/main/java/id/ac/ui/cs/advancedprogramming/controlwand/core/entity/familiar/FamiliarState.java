package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

import java.util.Stack;

public enum FamiliarState implements MagicalEntityState {
    SEALED,
    SUMMONED;
    // behaviour --> biasanya beda objek
    // ada perubahan algoritma

    @Override
    public void seal(MagicalEntity entity) {
        Familiar familiar = entity instanceof Familiar ? (Familiar) entity : null;
        if (familiar != null && this.equals(SUMMONED)) {
            familiar.getStateMemory().add(this);
            familiar.setState(SEALED);
            familiar.getStateHistory().add(SEALED);

        }
    }

    @Override
    public void summon(MagicalEntity entity) {
        Familiar familiar = entity instanceof Familiar ? (Familiar) entity : null;
        if (familiar != null && this.equals(SEALED)) {
            familiar.getStateMemory().add(this);
            familiar.setState(SUMMONED);
            familiar.getStateHistory().add(SUMMONED);
        }
    }

    @Override
    public void off(MagicalEntity magicTool) {
        //do nothing
    }

    @Override
    public void low(MagicalEntity magicTool) {
        //do nothing
    }

    @Override
    public void medium(MagicalEntity magicTool) {
        //do nothing
    }

    @Override
    public void high(MagicalEntity magicTool) {
        //do nothing
    }

    @Override
    public String toString() {
        if (this.equals(SUMMONED)) {
            return "SUMMONED";
        }
        return "SEALED";
    }
}
