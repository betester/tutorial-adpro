package id.ac.ui.cs.adpro.tutorial3.automata.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import id.ac.ui.cs.adpro.tutorial3.automata.service.DroidServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = AutomataController.class)
public class AutomataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DroidServiceImpl droidService;

    @Test
    public void whenUseAutomataURLisAccessedItShouldContainAutomataAndLogs() throws Exception {
        mockMvc.perform(get("/logistix"))
                .andExpect(status().isOk())
                .andExpect(handler().methodName("useAutomata"))
                .andExpect(model().attributeExists("automatas"))
                .andExpect(model().attributeExists("logs"))
                .andExpect(view().name("automata/index"));
        verify(droidService, times(1)).fetchDroids();
        verify(droidService, times(1)).fetchLogs();
    }

    @Test
    public void whenInventoryURLIsAccessedItShouldShowAllInventory() throws Exception {
        mockMvc.perform(get("/logistix/inventory"))
                .andExpect(status().isOk())
                .andExpect(handler().methodName("inventory"))
                .andExpect(model().attributeExists("inventories"))
                .andExpect(view().name("automata/inventory"));
        verify(droidService, times(1)).fetchInventories();
    }

    @Test
    public void whenDoURLisAccessedItShouldCallDoRoutine() throws Exception {
        mockMvc.perform(post("/logistix/do")
                .param("unit", "D2")
                .param("routine", "0"))
                .andExpect(handler().methodName("doRoutine"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/logistix"));
        verify(droidService, times(1)).doRoutine("D2", 0);
    }

    @Test
    public void whenAddInventoryURLItShouldAddNewInventory() throws Exception {
        mockMvc.perform(post("/logistix/addInventory")
                .param("item", "raiden sword"))
                .andExpect(status().is3xxRedirection())
                .andExpect(handler().methodName("addInventory"))
                .andExpect(redirectedUrl("/logistix/inventory"));
        verify(droidService, times(1)).addInventory("raiden sword");
    }
}
