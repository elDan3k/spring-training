package pl.training.bank.account;

import pl.training.bank.common.ResultPage;

import java.util.Optional;

public class HibernateAccountRepository implements AccountRepository {

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public ResultPage<Account> get(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Optional<Account> getByNumber(String accountNumber) {
        return Optional.empty();
    }

    @Override
    public void update(Account account) {

    }

}
