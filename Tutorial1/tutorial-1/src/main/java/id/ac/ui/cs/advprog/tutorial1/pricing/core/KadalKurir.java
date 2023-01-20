package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KadalKurir implements Kurir {
    int pricePerKilogram;
    public KadalKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Kadal";
    }

    public int getPricePerKilogram() {
        return pricePerKilogram;
    }

    public int calculatePrice(int weight) {
        return weight * pricePerKilogram;
    }
}
