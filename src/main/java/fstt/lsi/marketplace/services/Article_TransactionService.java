package fstt.lsi.marketplace.services;

import fstt.lsi.marketplace.models.Article_Transaction;
import fstt.lsi.marketplace.repository.Article_TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Article_TransactionService {

    @Autowired
    private Article_TransactionRepository repository;

    public Article_Transaction ajouterArticleAuTransaction(Article_Transaction at){
        return repository.save(at);
    }
}
