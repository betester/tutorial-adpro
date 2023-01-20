package id.ac.ui.cs.adpro.tutorial3.automata.core.adapter;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.DroidImpl;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;

import java.util.List;

public class FluidAdapter extends DroidImpl {
    private Fluids fluids;
    public FluidAdapter(Fluids fluid) {
        this.fluids = fluid;
    }

    @Override
    public String liftItem(String item) {
        return fluids.pushItem(item, Direction.Up);
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        String binary = fluids.splitBy(inventory,item);
        int decimal ;
        try {
            decimal =  Integer.parseInt(binary,2);
        }
        catch (NumberFormatException e) {
            return "";
        }
        return decimal + "";
    }

    @Override
    public String useTransporter() {
        return fluids.shapeShift(Shape.Transporter);
    }

    @Override
    public String useCrane() {
        return fluids.shapeShift(Shape.Crane);
    }

    @Override
    public String getName() {
        return fluids.getName();
    }
}
