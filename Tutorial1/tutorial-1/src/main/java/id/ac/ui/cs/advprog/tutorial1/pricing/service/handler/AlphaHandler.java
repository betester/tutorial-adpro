package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;

import java.util.List;

public class AlphaHandler implements AsuransiHandler{
    AsuransiHandler nextHandler;
    @Override
    public void handle(int total, int value, List<String> ret, AsuransiRepository asuransiRepository) {
        if (value <= 50_000 && value >= 1000) {
            Asuransi asuransiAlpha = asuransiRepository.findByName("Alpha");
            int totalAsuransi = total + asuransiAlpha.getPrice();
            ret.add("Menggunakan Asuransi Alpha");
            ret.add(String.format("Harga jasa asuransi: %d civil credits",asuransiAlpha.getPrice()));
            ret.add(String.format("total harga: %d + %d = %d civil credits",total,asuransiAlpha.getPrice(),totalAsuransi));
        }
            nextHandler.handle(total, value, ret,asuransiRepository);
    }

    @Override
    public void setNext(AsuransiHandler handle) {
        this.nextHandler = handle;
    }
}
