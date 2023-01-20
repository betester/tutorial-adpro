package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;

import java.util.List;

public interface KurirHandler {
    int handle(int weight, List<String> ret, KurirRepository kurirRepository);
    void setNext(KurirHandler handle);
}
