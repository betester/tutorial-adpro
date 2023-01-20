package id.ac.ui.cs.advancedprogramming.controlwand.core.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public abstract class MagicalEntity {
    protected String name;
    protected MagicalEntityState currentState;
    protected List<MagicalEntityState> stateHistory;
    protected Stack<MagicalEntityState> stateMemory;

    public MagicalEntity(String name) {
        this.name = name;
        stateHistory = new ArrayList<>();
        stateMemory = new Stack<>();
    }

    protected abstract String defineState(MagicalEntityState state);

    public String getName() {
        return name;
    }

    public void setState(MagicalEntityState state) {
        this.currentState = state;
    }

    public MagicalEntityState getCurrentState() {
        return currentState;
    }

    public List<MagicalEntityState> getStateHistory() {
        return stateHistory;
    }

    public List<MagicalEntityState> getStateMemory() {
        return stateMemory;
    }

    public List<String> getLifeArchive() {
        return stateHistory.stream().map(this::defineState).collect(Collectors.toList());
    }

    public void undo() {
        MagicalEntityState magicState = null;
        if (!stateMemory.empty()) {
            magicState =  stateMemory.pop();
            stateHistory.add(magicState);
        }
        if (magicState != null)
            this.setState(magicState);


    }
}
