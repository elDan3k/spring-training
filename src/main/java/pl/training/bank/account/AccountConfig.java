package pl.training.bank.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.bank.generator.AccountNumberGenerator;
import pl.training.bank.generator.JdbcTemplateIncrementalAccountNumberGenerator;

import javax.sql.DataSource;

@Configuration
public class AccountConfig {

    @Bean
    public AccountNumberGenerator accountNumberGenerator(DataSource dataSource) {
        return new JdbcTemplateIncrementalAccountNumberGenerator(dataSource);
    }

    @Bean
    public AccountRepository accountRepository(DataSource dataSource) {
        return new JdbcTemplateAccountRepository(dataSource);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AccountService accountService(AccountNumberGenerator accountNumberGenerator, AccountRepository accountRepository) {
        return new AccountService(accountNumberGenerator, accountRepository);
    }

}
