package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;

import java.util.List;

public interface AsuransiHandler {
    void handle(int total, int value, List<String> ret, AsuransiRepository asuransiRepository);
    void setNext(AsuransiHandler handler);
}
