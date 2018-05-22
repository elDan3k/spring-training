package pl.training.bank.operation.history;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.training.bank.account.Account;
import pl.training.bank.account.AccountNotFoundException;
import pl.training.bank.account.AccountRepository;
import pl.training.bank.disposition.Disposition;

import java.util.Date;

@RequiredArgsConstructor
public class OperationHistoryLogger {

    @NonNull
    private OperationHistoryRepository operationHistoryRepository;
    @NonNull
    private AccountRepository accountRepository;

    public void logOperation(Disposition disposition) {
        Account account = getAccount(disposition.getAccountNumber());
        OperationHistoryEntry historyEntry = createHistoryEntry(disposition, account);
        operationHistoryRepository.save(historyEntry);
    }

    private Account getAccount(String accountNumber) {
        return accountRepository.getByNumber(accountNumber)
                .orElseThrow(AccountNotFoundException::new);
    }

    private OperationHistoryEntry createHistoryEntry(Disposition disposition, Account account) {
        OperationHistoryEntry historyEntry = new OperationHistoryEntry();
        historyEntry.setAccount(account);
        historyEntry.setDate(new Date());
        historyEntry.setFunds(disposition.getFunds());
        historyEntry.setType(disposition.getOperationName());
        return historyEntry;
    }

}
