package id.ac.ui.cs.advprog.tutorial9.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.tutorial9.model.Article;
import id.ac.ui.cs.advprog.tutorial9.model.ArticleView;
import id.ac.ui.cs.advprog.tutorial9.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial9.repository.ArticleViewRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleViewRepository articleViewRepository;

    @Override
    public List<Article> getListArticle(int page, int limit){
        int offset = (page-1)*limit;
        var arts = articleRepository.listArticle(offset, limit);
        for (var art : arts) {
            art.setCreatedAtView(formatDate(art.getCreatedAt()));
        }
        return arts;
    }

    @Override
    public Article getArticleById(int id) {
        Article a = articleRepository.findById(id);
        return a;
    }

    private Date stringToDate(String date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");   
        Date pDate = new Date();
        pDate = formatter.parse(date); 

        return pDate;
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");   
        return formatter.format(date);
    }

    @Override
    public List<ArticleView> getArticleViewByDate(String date, int page, int limit) {
        
        int offset = (page-1)*limit;
        try {
            long aDay = TimeUnit.DAYS.toMillis(1);
            Date start = stringToDate(date);
            Date beforeTomorrow = new Date(start.getTime() + aDay - 1);
            var views = articleViewRepository.findByDate(start, beforeTomorrow, offset, limit);
            for (var view : views) {

                view.setDateDisplay(formatDate(view.getDate()));
            }
            return views;
        } catch(ParseException e) {
            return null;
        }
        
    }
    
}
