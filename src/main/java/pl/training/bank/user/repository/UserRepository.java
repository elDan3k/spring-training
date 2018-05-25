package pl.training.bank.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.training.bank.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByUsername(String username);

    @Transactional
    @Modifying
    @Query("delete from User u where u.username = :username and id = ?#{ principal?.id }")
    void deleteByLogin(@Param("username") String username);

}
