package pl.training.bank.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.bank.account.services.AccountService;

@Configuration
public class CustomerConfig {

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository, AccountService accountService) {
        return new CustomerService(customerRepository, accountService);
    }

}
