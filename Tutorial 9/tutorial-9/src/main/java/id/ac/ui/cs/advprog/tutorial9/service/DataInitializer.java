package id.ac.ui.cs.advprog.tutorial9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import id.ac.ui.cs.advprog.tutorial9.model.Article;
import id.ac.ui.cs.advprog.tutorial9.model.ArticleView;
import id.ac.ui.cs.advprog.tutorial9.model.Category;
import id.ac.ui.cs.advprog.tutorial9.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial9.repository.ArticleViewRepository;
import id.ac.ui.cs.advprog.tutorial9.repository.CategoryRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

// DO NOT TOUCH
@Component
public class DataInitializer {
    
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleViewRepository articleViewRepository;

    private Random random = new Random(42);

    private int NUM_CATEGORY = 10;
    private int NUM_ARTICLES = 10000;
    private int NUM_ARTICLES_VIEW = 50000;

    private void deleteAllTable() {
        articleViewRepository.deleteAll();
        articleRepository.deleteAll();
        categoryRepository.deleteAll();
        
    }

    private List<Category> initCategory() {

        ArrayList<String> catsName = new ArrayList<>(Arrays.asList("Technology", "Finance", "World News", "Programming", "Movies", 
                                                                    "Literature", "Meme", "Real Estate", "Academic", "Sports"));

        ArrayList<Category> cats = new ArrayList<>();
        for(var cat: catsName) {
            Category c = new Category(cat);
            cats.add(c);
            categoryRepository.save(c);
        }

        return cats;
    }

    private List<String> getWordList() {

        ArrayList<String> words = new ArrayList<>();

        try {
            File file = ResourceUtils.getFile("classpath:wordlist.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                words.add(data);
            }
            myReader.close();

        } catch(FileNotFoundException e) {
            System.out.println("=== FILE NOT FOUND ====");
            e.printStackTrace();
        }

        return words;
    }

    private String randomSentence(List<String> words, int min, int max) {
        StringBuilder sb = new StringBuilder();

        int sentenceLen = random.nextInt(max - min + 1) + min;
        int wordLen = words.size();
        for(var temp = 0; temp<sentenceLen; temp++) {
            var nextWord = words.get(random.nextInt(wordLen));
            sb.append(nextWord);
            if(temp != sentenceLen - 1) sb.append(" ");
        }

        return sb.toString();
    }

    private Date randomDate() {

        String start_date = "12-01-2021";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");   
        Date sDate = new Date();
        try {   
            sDate = formatter.parse(start_date); 
        } catch(ParseException e) {
            // do nothing
        }

        // randomly get a date from last year
        long aDay = TimeUnit.DAYS.toMillis(1);
        long timeRange = 11 * 30 * aDay;
        Date rDate = new Date(sDate.getTime() + random.nextLong()%timeRange);
        return rDate;

    }

    private List<Article> initArticle(List<Category> cats) {

        var catsSize = cats.size();

        ArrayList<Article> arts = new ArrayList<>();

        var words = getWordList();
        if(words.size() == 0) {
            return arts;
        }

        for(var temp = 0; temp < NUM_ARTICLES; temp++) {
            var a = new Article(randomSentence(words, 2, 5), randomSentence(words, 1000, 5000), cats.get(random.nextInt(catsSize)), randomDate());
            arts.add(a);
            articleRepository.save(a);
        }

        return arts;
        
    }

    private String randomIpAddress() {
        var sb = new StringBuilder();
        for(var temp =0; temp<4;temp++) {
            var next = random.nextInt(256);
            sb.append("" + next);
            if(temp != 3) sb.append(".");
        }
        return sb.toString();

    }



    private void initArticleView(List<Article> arts) {


        long aDay = TimeUnit.DAYS.toMillis(1);
        String date_string = "12-01-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");   
        Date curDate = new Date();
        try {   
            curDate = formatter.parse(date_string);  
        } catch(ParseException e) {
            // do nothing
        }

        var createdArticlesView = 0;
        CompletableFuture<Void> lastCf = null;
        while(createdArticlesView < NUM_ARTICLES_VIEW) {
            int articleToday = random.nextInt(Math.min(700, NUM_ARTICLES_VIEW - createdArticlesView + 1));

            for(var temp = 0; temp < articleToday; temp++) {
                Date randomTimeToday = new Date(curDate.getTime() + random.nextLong()%aDay);
                var articleView = new ArticleView(randomIpAddress(), randomTimeToday, arts.get(random.nextInt(arts.size())));
     
                CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> articleViewRepository.save(articleView));
                lastCf = cf;
            }

            curDate = new Date(curDate.getTime() + aDay);
            createdArticlesView += articleToday;
        }
        try {
            lastCf.get();
        } catch(InterruptedException|ExecutionException e) {
            // do nothing
        }
        //var allCfDone = CompletableFuture.allOf(cfs);
    }

    

    @PostConstruct
    public void init() {

        if(categoryRepository.count() != NUM_CATEGORY || 
           articleRepository.count() != NUM_ARTICLES || 
           articleViewRepository.count() != NUM_ARTICLES_VIEW
        ) {
            
            deleteAllTable();
            var cat = initCategory();
            var arts = initArticle(cat);
            initArticleView(arts);
        }
    }

}
