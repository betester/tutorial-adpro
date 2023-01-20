package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public interface HuntingStrategy {
    public void execute(List<String> allowedLocation, String location);
}
