package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public interface Kurir {
    
    String getName();
    public int getPricePerKilogram();
    int calculatePrice(int weight);
}
