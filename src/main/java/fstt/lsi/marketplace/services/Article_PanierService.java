package fstt.lsi.marketplace.services;

import fstt.lsi.marketplace.models.Article;
import fstt.lsi.marketplace.models.Article_Panier;
import fstt.lsi.marketplace.models.Panier;
import fstt.lsi.marketplace.repository.Article_PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Article_PanierService {

    @Autowired
    private Article_PanierRepository repository;

//    public Article_Panier ajouterArticleAuPanier(Article article , Panier panier){
//        Article_Panier ap = new Article_Panier();
//        ap.setArticle(article);
//        ap.setPanier(panier);
//        ap.setPrix(article.getPrixUnit());
//        ap.setQuantite(articl);
//    }
}
