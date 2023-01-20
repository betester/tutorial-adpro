package id.ac.ui.cs.advprog.tutorial1.pricing.controller;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.AlphaAsuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.KudaKurir;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.service.PricingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = PricingController.class)
public class PricingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricingService pricingService;

    private List<String> retList;

    @BeforeEach
    public void setUp(){
        retList = new ArrayList<>(Arrays.asList(
                "Menggunakan Kurir Kuda. fee: 30 x 500 = 15000 civil credits",
                "Menggunakan Asuransi Alpha. fee: 1000 civil credits",
                "Total Harga: 1000 + 15000 = 16000"
        ));
    }

    @Test
    public void testWhenHomeCalledWithoutInputtingParameterReturn200() throws Exception{

        mockMvc.perform(get("/pricing"))
                .andExpect(status().isOk());
    }

    @Test
    public void testWhenCalculateServiceCalledShouldReturnRightPrice() throws Exception{

        when(pricingService.calculatePrice(30, 25000)).thenReturn(retList);

        mockMvc.perform(post("/pricing/calculate-price")
                        .param("weight", "30")
                        .param("value", "25000"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("logs", hasSize(3)));

    }

}
