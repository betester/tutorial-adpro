package id.ac.ui.cs.adpro.tutorial3.automata.core.adapter;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.DroidImpl;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;

import java.util.List;

public class GolemAdapter extends DroidImpl {
    private Golem golem;

    public GolemAdapter(Golem golem) {
        this.golem = golem;
    }

    @Override
    public String liftItem(String item) {
        return golem.liftItem(item);
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        int count  = 0;
        for (String items : inventory) {
            if (golem.isItem(item,items).equals(String.format("item %s is %s",item,item))) {
                count++;
            }
        }

        return String.format("%s founds %d %s in inventory",getName(),count,item);
    }

    @Override
    public String useTransporter() {
        return golem.toss("transporter");
    }

    @Override
    public String useCrane() {
        return golem.punch(Punchable.CraneLever);
    }

    @Override
    public String getName() {
        return golem.getName();
    }
}
