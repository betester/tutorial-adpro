package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class GarudaKurir implements Kurir {
    int pricePerKilogram;
    public GarudaKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Garuda";
    }

    public int getPricePerKilogram() {
        return pricePerKilogram;
    }

    public int calculatePrice(int weight) {
        return weight * pricePerKilogram + 2000;
    }
}
