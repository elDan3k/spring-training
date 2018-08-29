package pl.training.bank.customer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.training.bank.account.entity.Account;
import pl.training.bank.account.services.AccountService;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomerService {

    @NonNull
    private CustomerRepository customerRepository;
    @NonNull
    private AccountService accountService;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void assignAccount(long customerId, long accountId) {
        customerRepository.findById(customerId).ifPresent(customer -> {
            Account account = accountService.getAccountById(accountId);
            customer.getAccounts().add(account);
            customerRepository.save(customer);
        });
    }


}
