package pl.training.bank.disposition.history;

import lombok.AllArgsConstructor;
import pl.training.bank.disposition.Disposition;

@AllArgsConstructor
public class HistoryLogger {

    private JdbcTemplateHistoryRepository historyRepository;

    public void onOperationSuccess(Disposition disposition) {
        HistoryEntry historyEntry = createHistoryEntry(disposition);
        historyRepository.save(historyEntry);
    }

    private HistoryEntry createHistoryEntry(Disposition disposition) {
        HistoryEntry historyEntry = new HistoryEntry();
        historyEntry.setAccountNumber(disposition.getAccountNumber());
        historyEntry.setFunds(disposition.getFunds());
        historyEntry.setOperationType(disposition.getOperationName());
        historyEntry.setTimestamp(System.currentTimeMillis());
        return historyEntry;
    }

}
