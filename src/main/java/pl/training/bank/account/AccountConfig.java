package pl.training.bank.account;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.bank.generator.AccountNumberGenerator;
import pl.training.bank.generator.HibernateIncrementalAccountNumberGenerator;

@Configuration
public class AccountConfig {

    @Bean
    public AccountNumberGenerator accountNumberGenerator(SessionFactory sessionFactory) {
        return new HibernateIncrementalAccountNumberGenerator(sessionFactory);
    }

    @Bean
    public AccountRepository accountRepository(SessionFactory sessionFactory) {
        return new HibernateAccountRepository(sessionFactory);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AccountService accountService(AccountNumberGenerator accountNumberGenerator, AccountRepository accountRepository) {
        return new AccountService(accountNumberGenerator, accountRepository);
    }

}
