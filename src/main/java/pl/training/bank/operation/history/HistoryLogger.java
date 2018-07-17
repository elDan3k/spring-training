package pl.training.bank.operation.history;

import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import pl.training.bank.disposition.Disposition;

@Aspect
@AllArgsConstructor
public class HistoryLogger {

    private JdbcTemplateHistoryRepository historyRepository;

    @AfterReturning("execution(void pl.training.bank.disposition.DispositionService.process(..)) && args(disposition)")
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
