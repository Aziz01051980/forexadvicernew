package myforexhelp.realtime.bootstrap;

import myforexhelp.realtime.Repository.ArticleRepository;
import myforexhelp.realtime.Repository.ImageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    public BootstrapData(ArticleRepository articleRepository, ImageRepository imageRepository) {
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
