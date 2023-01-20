package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;

import java.util.List;

public class KadalHandler implements KurirHandler{
    KurirHandler nextHandler;
    @Override
    public int handle(int weight, List<String> ret,  KurirRepository kurirRepository) {
        if (weight <= 10) {
            Kurir kurirKadal = kurirRepository.findByName("Kadal");
            int total = kurirKadal.calculatePrice(weight);
            ret.add("Menggunakan Kurir Kadal");
            ret.add(String.format("Harga jasa kurir: %s x %s = %d civil credits",kurirKadal.getPricePerKilogram(),weight,total));
            return total;
        }
        return nextHandler.handle(weight,ret,kurirRepository);
    }

    @Override
    public void setNext(KurirHandler handle) {
        this.nextHandler = handle;
    }
}
