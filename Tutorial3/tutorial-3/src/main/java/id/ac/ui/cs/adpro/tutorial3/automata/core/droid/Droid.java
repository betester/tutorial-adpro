package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import java.util.List;

public interface Droid {

    String liftItem(String item);

    String countItem(List<String> inventory, String item);

    String useTransporter();

    String useCrane();

    String getName();

    String getType();
}
