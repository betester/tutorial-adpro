package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class BetaAsuransi implements Asuransi {
    int price;
    public BetaAsuransi(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return "Beta";
    }

    @Override
    public int getPrice() {
        return price;
    }

}
