package id.ac.ui.cs.advprog.tutorial4.controller;

import id.ac.ui.cs.advprog.tutorial4.service.CreateCodeServiceImpl;
import id.ac.ui.cs.advprog.tutorial4.service.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = CreateCodeController.class)
public class CreateCodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateCodeServiceImpl createCodeService;

    @MockBean
    private ItemServiceImpl itemService;

    @Test
    public void whenGetCreateCodeURLShouldCallItemService() throws Exception {
        mockMvc.perform(get("/code/create"))
                .andExpect(status().isOk())
                .andExpect((handler().methodName("getCreatePage")))
                .andExpect(model().attributeExists("merchItems"))
                .andExpect(model().attributeExists("membershipItems"))
                .andExpect(model().attributeExists("dto"))
                .andExpect(view().name("create"));

        verify(itemService, times(1)).getAllMerchItem();
        verify(itemService, times(1)).getAllMembershipItem();
    }

    @Test
    public void whenPostCreateCodeURLShouldCallCreateCodeService() throws Exception {
        mockMvc.perform(post("/code/create")
                        .param("itemType", "merch")
                        .param("codeType", "promo")
                        .param("item", "Figurine")
                        .param("code", "testCode")
                        .param("data['discount']", "80")
                )
                .andExpect((handler().methodName("createCode")));

        verify(createCodeService, times(1)).createCode(any(String.class), any(String.class), any(String.class), any(String.class), anyMap());
        verify(itemService, times(1)).getAllMerchItem();
        verify(itemService, times(1)).getAllMembershipItem();
    }

}
