package id.ac.ui.cs.adpro.tutorial3.automata.core.fluids;

import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;
import java.util.List;

public interface Fluids {

    String pushItem(String item, Direction direction);

    String splitBy(List<String> inventory, String item);

    String shapeShift(Shape shape);

    String merge();

    String getName();
}
