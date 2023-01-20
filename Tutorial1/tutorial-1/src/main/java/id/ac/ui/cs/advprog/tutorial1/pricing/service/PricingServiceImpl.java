package id.ac.ui.cs.advprog.tutorial1.pricing.service;

import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.service.handler.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class PricingServiceImpl implements PricingService {
    
    @Autowired
    private KurirRepository kurirRepository;

    @Autowired
    private AsuransiRepository asuransiRepository;

    @Override
    public List<String> calculatePrice(int weight, int value) {
        KurirHandler garudaHandler = new GarudaHandler();
        KurirHandler kudaHandler = new KudaHandler();
        KurirHandler kadalHandler = new KadalHandler();

        AsuransiHandler betaHandler = new BetaHandler();
        AsuransiHandler alphaHandler = new AlphaHandler();
        AsuransiHandler sigmaHandler = new SigmaHandler();

        garudaHandler.setNext(kudaHandler);
        kudaHandler.setNext(kadalHandler);

        betaHandler.setNext(alphaHandler);
        alphaHandler.setNext(sigmaHandler);

        List<String> ret = new ArrayList<>();
//        kalau memang ada kemungkinan lebih dari satu handler, brarti perlu pass kurir dan asuransi repo(?) untuk
//        iterasi didalam handlernya
        int total = garudaHandler.handle(weight,ret,kurirRepository);
        betaHandler.handle(total,value,ret,asuransiRepository);
        return ret;
    }

}
