package myforexhelp.realtime.Controller;

import myforexhelp.realtime.Service.SearchingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import myforexhelp.realtime.Repository.ArticleRepository;

@RestController
@RequestMapping("/search")
public class SearchController {

    @RequestMapping(value = "/searchingdata/{searchValue}", method = RequestMethod.GET)
    public String myEndpoint(@PathVariable String searchValue) {
        if (searchValue.equals("ertyu"))
            // code to be executed by the endpoint
            return "Hello from the endpoint!";
        return searchValue;
    }
}

