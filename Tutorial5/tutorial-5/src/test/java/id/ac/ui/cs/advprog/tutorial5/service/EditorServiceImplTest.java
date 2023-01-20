package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.repository.EditorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class EditorServiceImplTest {
    @Mock
    private EditorRepository editorRepository;

    @InjectMocks
    private EditorServiceImpl editorService;

    private Editor editor;

    @BeforeEach
    public void setUp() {
        String editorName = "Pacil";
        String editorEmail = "pacil@pacil.com";
        int editorWrittenArticles = 0;
        editor = new Editor(editorName, editorEmail, editorWrittenArticles);
        editor.setId(0);
        editor.setRegisteredAt(new Date());
    }

    @Test
    public void testServiceCreateEditor() {
        lenient().when(editorService.createEditor(editor)).thenReturn(editor);
    }

    @Test
    public void testGetEditorById() {
        lenient().when(editorService.getEditorById(0)).thenReturn(editor);
        Editor calledEditor = editorService.getEditorById(0);
        assertEquals(calledEditor.getId(), editor.getId());
        assertEquals(calledEditor.getName(), editor.getName());
    }

    @Test
    public void testGetListEditor() {
        Iterable<Editor> listEditor = editorRepository.findAll();
        lenient().when(editorService.getListEditor()).thenReturn(listEditor);
        Iterable<Editor> listEditorResult = editorService.getListEditor();
        assertIterableEquals(listEditor, listEditorResult);
    }

    @Test
    public void testUpdateEditor() {
        editorService.createEditor(editor);
        String pastEmail = editor.getEmail();

        String newEmail = "fasilkom@pacil.com";
        editor.setEmail(newEmail);

        lenient().when(editorService.updateEditor(editor.getId(), editor)).thenReturn(editor);
        Editor editorResult = editorService.updateEditor(editor.getId(), editor);

        assertNotEquals(editorResult.getEmail(), pastEmail);
        assertEquals(editorResult.getId(), editor.getId());
    }

    @Test
    public void testDeleteEditorById() {
        editorService.createEditor(editor);
        lenient().when(editorRepository.findById(0)).thenReturn(editor);
        editorService.deleteEditorById(0);
        lenient().when(editorService.getEditorById(0)).thenReturn(null);
        assertNull(editorService.getEditorById(0));
    }

    @Test
    public void testDeleteNonExistentEditorById() {
        editorService.createEditor(editor);
        lenient().when(editorRepository.findById(0)).thenReturn(null);
        editorService.deleteEditorById(0);
    }
}
