package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.service.EditorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EditorController.class)
public class EditorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EditorService editorService;

    private Editor editor;
    private String editorName = "Fasilkom";
    private String editorEmail = "pacil@cs.ui.ac.id";
    private int editorWrittenArticles = 0;

    @BeforeEach
    public void setUp() {
        editor = new Editor(editorName, editorEmail, editorWrittenArticles);
    }

    @Test
    public void testPostEditor() throws Exception {
        when(editorService.createEditor(editor)).thenReturn(editor);

        mockMvc.perform(post("/editor")
                .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(editor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(editorName))
                .andExpect(jsonPath("$.email").value(editorEmail))
                .andExpect(jsonPath("$.writtenArticles").value(editorWrittenArticles));
    }

    @Test
    public void testGetListEditor() throws Exception {
        Iterable<Editor> editorsList = List.of(editor);
        when(editorService.getListEditor()).thenReturn(editorsList);

        mockMvc.perform(get("/editor").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value(editorName))
                .andExpect(jsonPath("$[0].email").value(editorEmail))
                .andExpect(jsonPath("$[0].writtenArticles").value(editorWrittenArticles));
    }

    @Test
    public void testGetNonExistentEditorById() throws Exception {
        mockMvc.perform(get("/editor/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetEditorById() throws Exception {
        when(editorService.getEditorById(0)).thenReturn(editor);

        mockMvc.perform(get("/editor/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(editorName));
    }

    @Test
    public void testUpdateEditor() throws Exception {
        editorService.createEditor(editor);
        String newEditorName = "UI";
        editor.setName(newEditorName);
        when(editorService.updateEditor(0, editor)).thenReturn(editor);

        mockMvc.perform(put("/editor/0")
                .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(editor)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(newEditorName));
    }

    @Test
    public void testDeleteEditorById() throws Exception {
        editorService.createEditor(editor);

        mockMvc.perform(delete("/editor/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
