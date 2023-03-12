package fstt.lsi.marketplace.repository;

import fstt.lsi.marketplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
