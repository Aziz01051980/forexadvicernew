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
}

