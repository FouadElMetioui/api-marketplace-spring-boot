package fstt.lsi.marketplace.controllers;

import fstt.lsi.marketplace.models.Article;
import fstt.lsi.marketplace.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")

    public List<Article> getArticles(){
        return articleService.getAllArticles();
    }

    @PostMapping("/article")
    public Article saveArticle(@RequestBody Article article) {
       return articleService.createArticle(article);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
    }

    @GetMapping("/article/{id}")
    public Optional<Article> getArticleById(@PathVariable("id") Long id)
    {
      return articleService.getArticleById(id);
    }


    @PutMapping("/article/{id}")
    public Article updateArticle(@RequestBody Article article , @PathVariable Long id){
        return articleService.updateArticle(article,id);
    }

}
