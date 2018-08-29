package pl.training.bank.account;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.bank.common.ResultPage;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> getByNumber(String accountNumber);

}
