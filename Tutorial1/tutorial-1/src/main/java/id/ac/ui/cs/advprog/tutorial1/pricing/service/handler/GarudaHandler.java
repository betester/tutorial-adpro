package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;

import java.util.List;

public class GarudaHandler implements KurirHandler {
    KurirHandler nextHandler;
    @Override
    public int handle(int weight,List<String> ret, KurirRepository kurirRepository) {
        if (weight > 50) {
            Kurir garudaKurir = kurirRepository.findByName("Garuda");
            int total = garudaKurir.calculatePrice(weight) ;
            ret.add("Menggunakan Kurir Garuda");
            ret.add("Biaya tambahan menggunakan Garuda: 2000 civil points");
            ret.add(String.format("Harga jasa kurir: %s x %s + 2000 = %d civil credits",garudaKurir.getPricePerKilogram(),weight,total));
            return total;
        }
        return nextHandler.handle(weight,ret,kurirRepository);
    }

    @Override
    public void setNext(KurirHandler handle) {
        this.nextHandler = handle;
    }
}
