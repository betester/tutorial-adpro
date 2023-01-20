package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import id.ac.ui.cs.adpro.tutorial3.automata.core.util.ItemCount;

import java.util.List;

public class Gemini extends DroidImpl implements Droid {
    private String name;
    public Gemini(String name) {
        this.name = name;
    }

    @Override
    public String liftItem(String item) {
        return String.format("Lifting %s with mechanical arms",item);
    }

    /**
     * Count numbers of wanted items inside inventory.
     *
     * @param inventory collection of items
     * @param wanted    item to count
     * @return String that describes the count result.
     */
    @Override
    public String countItem(List<String> inventory, String wanted) {
        int count = ItemCount.count(inventory,wanted);
        return String.format("Found %d %s",count,wanted);
    }

    @Override
    public String useTransporter() {
        return "Using Gemini-compatible transporter";
    }

    @Override
    public String useCrane() {
        return "Using Gemini-compatible crane";
    }

    @Override
    public String getName() {
        return this.name;
    }

}
