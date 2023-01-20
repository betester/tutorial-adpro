package id.ac.ui.cs.advprog.tutorial5.controller;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.service.ArticleService;
import id.ac.ui.cs.advprog.tutorial5.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/editor")
public class EditorController {
    @Autowired
    private EditorService editorService;


    @PostMapping(path = "/{id}/addArticle",produces = {"application/json"})
    @ResponseBody
    public ResponseEntity addArticle(@PathVariable(value = "id") int id, @RequestBody Article article) {
        editorService.addArticleEditor(id,article);
        return ResponseEntity.ok("Article successfully created");
    }

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postEditor(@RequestBody Editor editor) {
        return ResponseEntity.ok(editorService.createEditor(editor));
    }

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Editor>> getListEditor() {
        return ResponseEntity.ok(editorService.getListEditor());
    }
    @GetMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getEditor(@PathVariable(value = "id") int id) {
        Editor editor = editorService.getEditorById(id);
        if (editor == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(editor);
    }

    @PutMapping(path = "/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateEditor(@PathVariable(value = "id") int id, @RequestBody Editor editor) {
        return ResponseEntity.ok(editorService.updateEditor(id, editor));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity deleteEditor(@PathVariable(value = "id") int id) {
        editorService.deleteEditorById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{editorId}/{articleId}", produces = {"application/json"})
    public ResponseEntity deleteArticleFromEditor(@PathVariable(value = "editorId") int editorId,@PathVariable(value = "articleId") int articleId) {
        editorService.removeArticleEditor(editorId,articleId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
