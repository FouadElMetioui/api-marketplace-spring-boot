package fstt.lsi.marketplace.services;

import fstt.lsi.marketplace.models.Article;
import fstt.lsi.marketplace.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> getAllArticles(){
        return repository.findAll();
    }

    public Optional<Article> getArticleById(Long id){
        return repository.findById(id);
    }

    public void deleteArticle(Long id){
        repository.deleteById(id);
    }

    public Article createArticle(Article article){
        return repository.save(article);
    }

    public Article updateArticle(Article article , Long id){

       Article art = repository.getById(id);
       art.setImage(article.getImage());
       art.setDescription(article.getDescription());
       art.setNomArt(article.getNomArt());
       art.setQteStock(article.getQteStock());
       art.setPrixUnit(article.getPrixUnit());
       return repository.save(art);

    }
}
