package myforexhelp.realtime.bootstrap;

import myforexhelp.realtime.repository.ArticleRepository;
import myforexhelp.realtime.repository.ImageRepository;
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
