package id.ac.ui.cs.advprog.tutorial4.core.item;

public class MembershipItem implements Item {
    private String name;

    public MembershipItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
