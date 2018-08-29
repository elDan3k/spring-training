package pl.training.bank.operation.history;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends CrudRepository<HistoryEntry, Long>  {
    
    @Query("select e from HistoryEntry e where  e.funds >= :funds")
    List<HistoryEntry> getEntriesWithFunds(@Param("funds") long funds); 
    
    List<HistoryEntry> getByOperationName(String operation);
    
}
