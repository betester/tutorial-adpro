package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ManaIntensity implements MagicalEntityState {
    NONE, LOW, MEDIUM, HIGH;

    public static List<ManaIntensity> getNonNullManaIntensities() {
        return Arrays.stream(ManaIntensity.values())
                .filter(v -> v != ManaIntensity.NONE)
                .collect(Collectors.toList());
    }

    @Override
    public void seal(MagicalEntity entity) {
        // do nothing
    }

    @Override
    public void summon(MagicalEntity entity) {
        // do nothing
    }

    @Override
    public void off(MagicalEntity entity) {
        MagicTool magicTool = entity instanceof MagicTool ? (MagicTool) entity : null;
        if (magicTool != null && !this.equals(NONE)) {
            magicTool.getStateMemory().add(this);
            magicTool.setState(NONE);
            magicTool.getStateHistory().add(NONE);
        }
    }

    @Override
    public void low(MagicalEntity entity) {
        MagicTool magicTool = entity instanceof MagicTool ? (MagicTool) entity : null;
        if (magicTool != null && !this.equals(LOW)) {
            magicTool.getStateMemory().add(this);
            magicTool.setState(LOW);
            magicTool.getStateHistory().add(LOW);
        }
    }

    @Override
    public void medium(MagicalEntity entity) {
        MagicTool magicTool = entity instanceof MagicTool ? (MagicTool) entity : null;
        if (magicTool != null && !this.equals(MEDIUM)) {
            magicTool.getStateMemory().add(this);
            magicTool.setState(MEDIUM);
            magicTool.getStateHistory().add(MEDIUM);
        }
    }

    @Override
    public void high(MagicalEntity entity) {
        MagicTool magicTool = entity instanceof MagicTool ? (MagicTool) entity : null;
        if (magicTool != null && !this.equals(HIGH)) {
            magicTool.getStateMemory().add(this);
            magicTool.setState(HIGH);
            magicTool.getStateHistory().add(HIGH);
        }
    }

    @Override
    public String toString() {
        if (this.equals(NONE)) {
            return "NONE";
        } else if (this.equals(LOW)) {
            return "LOW";
        }
        else if (this.equals(MEDIUM)) {
            return "MEDIUM";
        }
        else {
            return "HIGH";
        }
    }
}
