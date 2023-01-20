package id.ac.ui.cs.advprog.tutorial1.pricing.service;


import id.ac.ui.cs.advprog.tutorial1.pricing.core.AlphaAsuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.KudaKurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PricingServiceImplTest {

    @Mock
    private AsuransiRepository asuransiRepository;

    @Mock
    private KurirRepository kurirRepository;

    @InjectMocks
    PricingServiceImpl pricingService;

    @Test
    public void testWhenCalculatePriceCalledShouldUseRightStrategy(){

        AlphaAsuransi alphaMock = new AlphaAsuransi(1000);
        KudaKurir kurirMock = new KudaKurir(100);

        when(kurirRepository.findByName("Kuda")).thenReturn(kurirMock);
        when(asuransiRepository.findByName("Alpha")).thenReturn(alphaMock);

        List<String> ret = pricingService.calculatePrice(30, 25000);

        verify(asuransiRepository, times(1)).findByName("Alpha");
        verify(kurirRepository, times(1)).findByName("Kuda");

        assertEquals("total harga: 3000 + 1000 = 4000 civil credits", ret.get(ret.size()-1));

    }

}
