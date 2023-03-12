package fstt.lsi.marketplace;

import fstt.lsi.marketplace.models.Article;
import fstt.lsi.marketplace.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class MarketplaceApplication {

    @Autowired
    ArticleRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MarketplaceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ArticleRepository repository) {
        return args->{
            Article ar  = new Article("iphone3","est un telephone2","/image2",12.4,40);
            repository.save(ar);
        };
    }

}
