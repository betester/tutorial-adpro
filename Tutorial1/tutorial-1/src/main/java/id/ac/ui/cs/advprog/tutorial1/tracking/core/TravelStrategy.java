package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public interface TravelStrategy {
    public String execute(String dragonCurrentLocation,
                          String sweetsCurrentLocation,
                          List<String> ret ,
                          String location);
}
