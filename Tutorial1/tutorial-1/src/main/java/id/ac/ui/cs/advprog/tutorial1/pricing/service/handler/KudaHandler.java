package id.ac.ui.cs.advprog.tutorial1.pricing.service.handler;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;

import java.util.List;

public class KudaHandler implements  KurirHandler{
    KurirHandler nextHandler;
    @Override
    public int handle(int weight, List<String> ret, KurirRepository kurirRepository) {
        if (weight <= 50 && weight > 10 ) {
            Kurir kudaKurir = kurirRepository.findByName("Kuda");
            int total = kudaKurir.calculatePrice(weight);
            ret.add("Menggunakan Kurir Kuda");
            ret.add(String.format("Harga jasa kurir: %s x %s = %d civil credits",kudaKurir.getPricePerKilogram(),weight,total));
            return total;
        }
        return nextHandler.handle(weight,ret,kurirRepository);

    }

    @Override
    public void setNext(KurirHandler handle) {
        this.nextHandler = handle;
    }
}
