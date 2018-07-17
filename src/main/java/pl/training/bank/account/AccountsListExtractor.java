package pl.training.bank.account;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountsListExtractor implements ResultSetExtractor<List<Account>> {

    private AccountExtractor accountExtractor = new AccountExtractor();

    @Override
    public List<Account> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            accountExtractor.mapAccount(resultSet).ifPresent(accounts::add);
        }
        return accounts;
    }

}
