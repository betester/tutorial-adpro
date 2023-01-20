package id.ac.ui.cs.advprog.tutorial1.pricing;

import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

@Component
public class PricingInitializer {

    @Autowired
    private KurirRepository kurirRepository;

    @Autowired
    private AsuransiRepository asuransiRepository;

    @PostConstruct
    public void init() {
        
        kurirRepository.addKurir("Kadal", new KadalKurir(10));
        kurirRepository.addKurir("Kuda", new KudaKurir(50));
        kurirRepository.addKurir("Garuda", new GarudaKurir(100));

        asuransiRepository.addAsuransi("Alpha", new AlphaAsuransi(1000));
        asuransiRepository.addAsuransi("Beta", new BetaAsuransi(200));
        asuransiRepository.addAsuransi("Sigma", new SigmaAsuransi(5000));



    }
}
