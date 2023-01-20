package id.ac.ui.cs.advancedprogramming.inventory.controller;

import id.ac.ui.cs.advancedprogramming.inventory.core.Dummy;
import id.ac.ui.cs.advancedprogramming.inventory.core.DummyType;
import id.ac.ui.cs.advancedprogramming.inventory.service.StorageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = StorageController.class)
public class StorageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StorageServiceImpl storageService;

    @Test
    public void whenGetDummyInventoryUrlItShouldHaveCorrectAttributes() throws Exception {
        mockMvc.perform(get("/dummy-inventory"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("dummies"))
                .andExpect(model().attributeExists("dummyTypes"))
                .andExpect(view().name("inventory/dummy_inventory"));
    }

    @Test
    public void whenGetDummyInventoryUrlWithIndexItShouldHaveCorrectAttributes() throws Exception {
        int index = 1;
        Dummy dummy = Mockito.mock(Dummy.class, Mockito.CALLS_REAL_METHODS);
        when(storageService.getDummy(index)).thenReturn(dummy);
        mockMvc.perform(get("/dummy-inventory/" + index))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("dummy"))
                .andExpect(model().attributeExists("dummyIndex"))
                .andExpect(view().name("inventory/dummy_bio"));
    }

    @Test
    public void whenPostStoreDummyUrlItShouldCallStorageServiceCreateDummyMethod() throws Exception {
        float weight = 10;
        DummyType dummyType = DummyType.MELEE;
        String weapon = "Greatsword";

        mockMvc.perform(
                post("/store-dummy")
                        .param("weight", Float.toString(weight))
                        .param("dummyType", dummyType.name())
                        .param("weapon", weapon)
                ).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/dummy-inventory"));

        verify(storageService, times(1)).createDummy(weight, dummyType, weapon);
    }

    @Test
    public void whenDeleteRemoveDummyWithIndexUrlItShouldCallStorageServiceRemoveDummy() throws Exception {
        int index = 1;

        mockMvc.perform(delete("/remove-dummy/" + index))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/dummy-inventory"));

        verify(storageService, times(1)).removeDummy(index);
    }
}
