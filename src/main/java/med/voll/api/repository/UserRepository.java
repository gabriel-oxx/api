package med.voll.api.repository;

import med.voll.api.models.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
	UserDetails findByUserName(String userName);
}
