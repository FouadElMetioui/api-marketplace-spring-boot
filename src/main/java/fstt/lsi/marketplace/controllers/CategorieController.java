package fstt.lsi.marketplace.controllers;

import fstt.lsi.marketplace.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import fstt.lsi.marketplace.models.Categorie;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")

    public List<Categorie> getCategoriess(){
        return categorieService.getAllCategories();
    }

    @PostMapping("/categorie")
    public Categorie saveCategorie(@RequestBody Categorie categorie) {
        return categorieService.createCategorie(categorie);
    }

    @DeleteMapping("/categorie/{id}")
    public void deleteCategorie(@PathVariable("id") Long id) {
        categorieService.deleteCategorie(id);
    }

    @GetMapping("/categorie/{id}")
    public Optional<Categorie> getCategorieById(@PathVariable("id") Long id)
    {
        return categorieService.getCategorieById(id);
    }


    @PutMapping("/categorie/{id}")
    public Categorie updateCategorie(@RequestBody Categorie categorie , @PathVariable Long id){
        return categorieService.updateCategorie(categorie,id);
    }

}
