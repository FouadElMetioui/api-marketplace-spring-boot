package fstt.lsi.marketplace.repository;

import fstt.lsi.marketplace.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
