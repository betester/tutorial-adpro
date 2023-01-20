package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class AlphaAsuransi implements Asuransi {
    int price;

    public AlphaAsuransi(int price) {
        this.price = price;

    }

    @Override
    public String getName() {
        return "Alpha";
    }

    @Override
    public int getPrice() {
        return price;
    }

}
