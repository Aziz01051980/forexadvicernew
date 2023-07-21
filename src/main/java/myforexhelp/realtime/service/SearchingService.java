package myforexhelp.realtime.service;

import myforexhelp.realtime.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchingService {

    @Autowired
    private ArticleRepository articleRepository;


    public List<Object[]> articleConverter() {
        List<Object[]> articleList = articleRepository.findTitleAndId();
        return articleList;
    }

    public List<Object[]> getTitleDescriptionAndContentByid() {
        List<Object[]> articleList = articleRepository.findTitleDescriptionAndTitle();
        return articleList;
    }

    public Object[] getContentOfArticleById(Long id) {
        List<Object[]> articleLists = articleRepository.findTitleDescriptionAndTitle();
        for (Object[] article : articleLists) {
            if (article[0] == id) {
                return article;
            }
        }
        return null;
    }
}

