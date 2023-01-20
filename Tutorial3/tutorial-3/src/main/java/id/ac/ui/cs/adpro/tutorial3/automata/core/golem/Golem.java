package id.ac.ui.cs.adpro.tutorial3.automata.core.golem;

import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;
import java.util.List;

public interface Golem {

    String liftItem(String item);

    String isItem(String item1, String item2);

    String punch(Punchable punchable);

    String toss(String item);

    String getName();
}
