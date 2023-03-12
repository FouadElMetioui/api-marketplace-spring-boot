package fstt.lsi.marketplace.services;

import fstt.lsi.marketplace.models.Categorie;
import fstt.lsi.marketplace.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repository;

    public List<Categorie> getAllCategories(){
        return repository.findAll();
    }

    public Optional<Categorie> getCategorieById(Long id){
        return repository.findById(id);
    }

    public void deleteCategorie(Long id){
        repository.deleteById(id);
    }

    public Categorie createCategorie(Categorie categorie){return repository.save(categorie); }

    public Categorie updateCategorie(Categorie categorie , Long id){
        Categorie cat = repository.getById(id);
        cat.setNomCat(categorie.getNomCat());
        return repository.save(cat);
    }
}
