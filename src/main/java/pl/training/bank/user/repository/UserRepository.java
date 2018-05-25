package pl.training.bank.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.bank.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByUsername(String username);

}
