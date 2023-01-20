package id.ac.ui.cs.advprog.tutorial4.controller;

import id.ac.ui.cs.advprog.tutorial4.service.CreateCodeServiceImpl;
import id.ac.ui.cs.advprog.tutorial4.service.ItemServiceImpl;
import id.ac.ui.cs.advprog.tutorial4.service.RedeemCodeServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = RedeemCodeController.class)
public class RedeemCodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RedeemCodeServiceImpl redeemCodeService;

    @Test
    public void whenGetRedeemCodeURLShouldReturnRedeemPage() throws Exception {
        mockMvc.perform(get("/code/redeem"))
                .andExpect(status().isOk())
                .andExpect((handler().methodName("getRedeemPage")))
                .andExpect(model().attributeExists("dto"))
                .andExpect(view().name("redeem"));
    }

    @Test
    public void whenPostRedeemCodeURLShouldCallRedeemCodeService() throws Exception {
        when(redeemCodeService.redeemCode("testCode")).thenReturn("dummyResult");

        mockMvc.perform(post("/code/redeem")
                        .param("code", "testCode")
                )
                .andExpect((handler().methodName("redeemCode")));

        verify(redeemCodeService, times(1)).redeemCode(any(String.class));
    }

}
