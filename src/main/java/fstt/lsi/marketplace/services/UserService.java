package fstt.lsi.marketplace.services;

import fstt.lsi.marketplace.models.Panier;
import fstt.lsi.marketplace.models.User;
import fstt.lsi.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    PanierService panierService;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public void deleteUserById(Long id){
        repository.deleteById(id);
    }

    public User createUser(User user){
        User user1 =  repository.save(user);
        Panier panier  = new Panier();
        panier.setUser(user);
        panier.setPrixItems(0D);
        panier.setQteItems(0);
        panierService.creerPanier(panier);
        return user1;
    }

    public Optional<User> getById(Long id){
        return repository.findById(id);
    }

    public User updateUser(User user, Long id){
        User user1 = repository.getById(id);
        user1.setAddress(user.getAddress());
        user1.setPays(user.getPays());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setTelephone(user.getTelephone());
        user1.setVille(user.getVille());
        user1.setPassword(user.getPassword());

        return repository.save(user1);
    }
}
