package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class SigmaAsuransi implements Asuransi {
    int price;
    public SigmaAsuransi(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return "Sigma";
    }

    @Override
    public int getPrice() {
        return price;
    }

}
