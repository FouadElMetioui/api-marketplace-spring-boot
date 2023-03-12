package fstt.lsi.marketplace.controllers;

import fstt.lsi.marketplace.models.Panier;
import fstt.lsi.marketplace.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class PanierController {

    @Autowired
    private PanierService panierService;

    @GetMapping("/paniers")
    public List<Panier> getPaniers(){
        return panierService.getAllPanier();
    }

    @PostMapping("/panier")
    public Panier savePanier(Panier panier) {
        return panierService.creerPanier(panier);
    }

    @DeleteMapping("/panier/{id}")
    public void deletePanier(@PathVariable("id") Long id) {
        panierService.deletePanier(id);
    }

    @GetMapping("/panier/{id}")
    public Panier getPanierById(@PathVariable("id") Long id)
    {
        return panierService.getPanierById(id);
    }

   @GetMapping("/panier-article/{idPanier}/{idArticle}")
    public void removeFromPanier(@PathVariable Long idPanier , @PathVariable Long idArticle){
        panierService.removeFromPanier(idPanier,idArticle);
   }

    @GetMapping("/panier-article-ajouter/{idPanier}/{idArticle}")
    public void AjouterAuPanier(@PathVariable Long idPanier , @PathVariable Long idArticle){
        panierService.ajouterAuPanier(idPanier,idArticle);
    }


}
