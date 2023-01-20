package id.ac.ui.cs.adpro.tutorial3.automata.core.fluids;

import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;
import java.util.List;

/*
    DO NOT TOUCH
*/
public class Slime implements Fluids {

    private String name;
    private boolean isSplitted;

    public Slime(String name) {
        this.name = name;
        this.isSplitted = false;
    }

    @Override
    public String pushItem(String item, Direction direction) {
        return "Pushing " + item + " " + direction;
    }

    @Override
    public String splitBy(List<String> inventory, String wanted) {
        long count = inventory.stream()
            .filter(x -> x.equals(wanted))
            .count();
        this.isSplitted = true;

        return Long.toBinaryString(count);
    }

    @Override
    public String shapeShift(Shape shape) {
        if (this.isSplitted) {
            return "Not enough body to shape shift";
        } else {
            return "Shape shift into " + shape;
        }
    }

    @Override
    public String merge() {
        this.isSplitted = false;
        return "Merging bodies";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
