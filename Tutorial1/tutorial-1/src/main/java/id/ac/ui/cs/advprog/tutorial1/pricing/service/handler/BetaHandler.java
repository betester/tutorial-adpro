package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;

import java.util.List;

public class BetaHandler implements AsuransiHandler{
    AsuransiHandler nextHandler;
    @Override
    public void handle(int total, int value, List<String> ret, AsuransiRepository asuransiRepository) {

        if (value < 1000) {
            Asuransi betaAsuransi = asuransiRepository.findByName("Beta");
            int totalAsuransi = total + betaAsuransi.getPrice();
            ret.add("Menggunakan Asuransi Beta");
            ret.add(String.format("Harga jasa asuransi: %d civil credits",betaAsuransi.getPrice()));
            ret.add(String.format("total harga: %d + %d = %d civil credits",total,betaAsuransi.getPrice(),totalAsuransi));
        }
            nextHandler.handle(total,value,ret,asuransiRepository);
    }

    @Override
    public void setNext(AsuransiHandler handle) {
        this.nextHandler = handle;
    }
}
