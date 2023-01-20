package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KudaKurir implements Kurir {
    int pricePerKilogram;
    public KudaKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Kuda";
    }

    public int getPricePerKilogram() {
        return pricePerKilogram;
    }

    public int calculatePrice(int weight) {
        return weight * pricePerKilogram;
    }
}
