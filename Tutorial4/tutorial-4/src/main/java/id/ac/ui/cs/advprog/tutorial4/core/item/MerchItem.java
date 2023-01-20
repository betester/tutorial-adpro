package id.ac.ui.cs.advprog.tutorial4.core.item;

public class MerchItem implements Item {
    private String name;

    public MerchItem(String name) {
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
