package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;

import java.util.List;

public class SigmaHandler implements AsuransiHandler{
    AsuransiHandler nextHandler;
    @Override
    public void handle(int total, int value, List<String> ret, AsuransiRepository asuransiRepository) {
        if (value > 50_000) {
            Asuransi sigmaAsuransi = asuransiRepository.findByName("Sigma");

            int totalAsuransi = total + sigmaAsuransi.getPrice();
            ret.add("Menggunakan Asuransi Sigma");
            ret.add(String.format("Harga jasa asuransi: 5000 civil credits",sigmaAsuransi.getPrice()));
            ret.add(String.format("total harga: %d + %d = %d civil credits", total,sigmaAsuransi.getPrice() ,totalAsuransi));
        }
    }

    @Override
    public void setNext(AsuransiHandler handle) {
        this.nextHandler = handle;
    }
}
