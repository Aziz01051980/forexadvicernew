package myforexhelp.realtime.Service;

import myforexhelp.realtime.Domain.Article;
import myforexhelp.realtime.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchingService {

    @Autowired
    private ArticleRepository articleRepository;


    public List<Object[]> articleConverter() {
        List<Object[]> articleList = articleRepository.findTitleAndId();
        return articleList;
    }

//    public List<Article> allArticles() {
//        List<Article> allContents = articleRepository.findContentById();
//        return allContents;
//    }

    public List<Object[]> getTitleDescriptionAndContentByid() {
        List<Object[]> articleList = articleRepository.findTitleDescriptionAndTitle();
        return articleList;
    }
}

