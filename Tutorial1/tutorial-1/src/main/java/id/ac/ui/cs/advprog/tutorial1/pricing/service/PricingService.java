package id.ac.ui.cs.advprog.tutorial1.pricing.service;

import java.util.List;

public interface PricingService {
    List<String> calculatePrice(int weight, int value);
}
