package id.ac.ui.cs.advancedprogramming.controlwand.controller;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;
import id.ac.ui.cs.advancedprogramming.controlwand.service.ControlWandServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = WandController.class)
public class WandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ControlWandServiceImpl wandService;

    @Test
    public void whenGetControlWandUrlItShouldHaveCorrectAttributes() throws Exception {
        mockMvc.perform(get("/control-wand"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("spellNames"))
                .andExpect(model().attributeExists("entities"))
                .andExpect(view().name("controlwand/control_wand"));
    }

    @Test
    public void whenGetContractFormUrlItShouldHaveCorrectAttributes() throws Exception {
        mockMvc.perform(get("/contract-form"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("manaIntensities"))
                .andExpect(view().name("controlwand/contract_form"));
    }

    @Test
    public void whenPostCastUrlItShouldCallControlWandServiceCastMethod() throws Exception {
        String spellName = "Fireball";

        mockMvc.perform(post("/cast").param("spellName", spellName))
                .andExpect(handler().methodName("castSpell"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/control-wand"));

        verify(wandService, times(1)).castSpell(spellName);
    }

    @Test
    public void whenPostBuyMagicToolItShouldCallServiceBuyMagicToolMethod() throws Exception {
        String magicToolName = "New magic tool";

        mockMvc.perform(post("/buy-magictool")
                        .param("name", magicToolName)
                        .param("requiredSpells", ManaIntensity.HIGH.toString(), ManaIntensity.MEDIUM.toString()))
                .andExpect(handler().methodName("contract"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/control-wand"));

        verify(wandService, times(1)).buyMagicTool(anyString(), any());
    }

    @Test
    public void whenPostContractFamiliarUrlItShouldCallControlWandServiceContractFamiliarMethod() throws Exception {
        String familiarName = "Oz";

        mockMvc.perform(post("/contract-familiar").param("name", familiarName))
                .andExpect(handler().methodName("contract"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/control-wand"));

        verify(wandService, times(1)).contractFamiliar(familiarName);
    }

    @Test
    public void whenGetUndoUrlItShouldCallControlWandServiceUndoSpellMethod() throws Exception {
        mockMvc.perform(get("/undo"))
                .andExpect(handler().methodName("undoSpell"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/control-wand"));

        verify(wandService, times(1)).undoSpell();
    }
}