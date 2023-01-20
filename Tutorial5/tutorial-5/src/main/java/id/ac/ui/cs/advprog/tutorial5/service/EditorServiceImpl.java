package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EditorServiceImpl implements EditorService {

    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Editor createEditor(Editor editor) {
        editor.setRegisteredAt(new Date());
        editorRepository.save(editor);
        return editor;
    }

    @Override
    public Editor getEditorById(int id) {
        return editorRepository.findById(id);
    }

    @Override
    public Iterable<Editor> getListEditor() {
        return editorRepository.findAll();
    }

    @Override
    public Editor updateEditor(int id, Editor editor) {
        editor.setId(id);
        editorRepository.save(editor);
        return editor;
    }

    @Override
    public void deleteEditorById(int id) {
        Editor editor = editorRepository.findById(id);
        if(editor != null)
            editorRepository.delete(editor);
    }

    @Override
    public void addArticleEditor(int id, Article article) {
        Editor editor = editorRepository.findById(id);

        if (editor == null) {
            return;
        }

        editor.getArticles().add(article);
        article.setEditor(editor);
        articleRepository.save(article);

    }

    @Override
    public void removeArticleEditor(int editorId, int articleId) {
        Editor editor = editorRepository.getById(editorId);
        Article article = articleRepository.getById(articleId);
        boolean contain = editor.getArticles().remove(article);

        if (contain) {
            article.setEditor(null);
        }

        articleRepository.save(article);
        editorRepository.save(editor);

    }
}
