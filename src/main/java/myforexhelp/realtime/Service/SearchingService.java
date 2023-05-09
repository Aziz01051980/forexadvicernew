package myforexhelp.realtime.Service;

import myforexhelp.realtime.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchingService {

    @Autowired
    private static ArticleRepository articleRepository;


//    public static String gettingDataBySearchingDetails(String searchDetails) {
//
//         newDescription = articleRepository.findAll();
//
//
//
//
//        return null;
//    }
}
