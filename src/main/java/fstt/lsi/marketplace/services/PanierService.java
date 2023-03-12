package fstt.lsi.marketplace.services;

import fstt.lsi.marketplace.models.Article;
import fstt.lsi.marketplace.models.Article_Panier;
import fstt.lsi.marketplace.models.Panier;
import fstt.lsi.marketplace.repository.ArticleRepository;
import fstt.lsi.marketplace.repository.Article_PanierRepository;
import fstt.lsi.marketplace.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanierService {

    @Autowired
    private PanierRepository repository;

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private Article_PanierRepository article_panierRepository;

    public void clearPanier(){
        article_panierRepository.deleteAll();
    }

    public List<Panier> getAllPanier(){
        return repository.findAll();
    }

    public Panier creerPanier(Panier panier){
        return repository.save(panier);
    }

    public void deletePanier(Long id){
        repository.deleteById(id);
    }

    public Panier getPanierById(Long id){
        return repository.getById(id);
    }

    public void removeFromPanier(Long idPanier , Long idArticle ) {
        Panier panier = getPanierById(idPanier);
        Article article  = articleRepository.getById(idArticle);
        List<Article_Panier> aps = new ArrayList<>();
        boolean flag = false;
        for (Article_Panier ap : aps){
            if(ap.getPanier() == panier && ap.getArticle() == article){
                if(ap.getQuantite() == 1){
                      article_panierRepository.delete(ap);
                }
                else {
                    ap.setQuantite(ap.getQuantite() - 1);
                    article_panierRepository.save(ap);
                }
            }
        }
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void ajouterAuPanier(Long idPanier , Long idArticle){
        Panier panier = getPanierById(idPanier);
        Article article  = articleRepository.getById(idArticle);
        List<Article_Panier> aps = new ArrayList<>();
        boolean flag = false;
        for (Article_Panier ap : aps){
            if (ap.getPanier() == panier && ap.getArticle() == article){
                flag = true;
                ap.setQuantite(ap.getQuantite()+1);
                ap.setPrix(ap.getPrix()+article.getPrixUnit());
                article_panierRepository.save(ap);

            }
        }
        if(!flag){
            Article_Panier ap =  new Article_Panier();
            ap.setPanier(panier);
            ap.setPrix(article.getPrixUnit());
            ap.setQuantite(1);
            ap.setArticle(article);
            article_panierRepository.save(ap);
        }
    }

}
