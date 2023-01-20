package id.ac.ui.cs.adpro.tutorial3.transliteration.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import id.ac.ui.cs.adpro.tutorial3.transliteration.service.TransliterationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = TransliterationController.class)
public class TransliterationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransliterationServiceImpl transliterationService;

    @Test
    public void whenHomeIsAccesedReturnTranslateFormPage() throws Exception {
        mockMvc.perform(get("/linguamorphism/"))
            .andExpect(status().isOk())
            .andExpect(handler().methodName("home"))
            .andExpect(view().name("transliteration/translateForm"));
    }

    @Test
    public void whenParseLanguageIsAccessedReturnTranslatePage() throws Exception {
        String type = "text";
        String text = "actually i think ganyu is wangy";
        mockMvc.perform(post("/linguamorphism/parseLanguage")
            .param("type", type)
            .param("text", text))
            .andExpect(handler().methodName("translateForm"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/linguamorphism/translate"));
        verify(transliterationService, atLeastOnce()).setRequestType(type);
        verify(transliterationService, atLeastOnce()).setRequestValue(text);
    }

    @Test
    public void whenTranslatePageIsAccessedReturnResultPage() throws Exception {
        String text = "actually i think ganyu is wangy";
        when(transliterationService.isRequestEncode()).thenReturn(true);
        when(transliterationService.getRequestValue()).thenReturn(text);
        when(transliterationService.encode(text)).thenReturn("encodedStuff");
        mockMvc.perform(get("/linguamorphism/translate"))
            .andExpect(model().attributeExists("inputType"))
            .andExpect(model().attributeExists("input"))
            .andExpect(model().attributeExists("result"))
            .andExpect(view().name("transliteration/result"));
        verify(transliterationService, atLeastOnce()).isRequestEncode();
        verify(transliterationService, atLeastOnce()).getRequestValue();
        verify(transliterationService, atLeastOnce()).encode(text);
    }
}
