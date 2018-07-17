package pl.training.bank.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.bank.operation.DepositOperation;
import pl.training.bank.operation.LargeDepositListener;
import pl.training.bank.operation.LargeDepositLogger;
import pl.training.bank.operation.WithdrawOperation;
import pl.training.bank.operation.history.HistoryLogger;
import pl.training.bank.operation.history.JdbcTemplateHistoryRepository;

import javax.sql.DataSource;

@Configuration
public class OperationConfig {

    @Bean
    public DepositOperation deposit() {
        return new DepositOperation();
    }

    @Bean
    public WithdrawOperation withdraw() {
        return new WithdrawOperation();
    }

    @Bean
    public LargeDepositLogger largeDepositLogger() {
        return new LargeDepositLogger();
    }

    @Bean
    public LargeDepositListener largeDepositListener() {
        return new LargeDepositListener();
    }

    @Bean
    public JdbcTemplateHistoryRepository jdbcTemplateHistoryRepository(DataSource dataSource) {
        return new JdbcTemplateHistoryRepository(dataSource);
    }

    @Bean
    public HistoryLogger historyLogger(JdbcTemplateHistoryRepository historyRepository) {
        return new HistoryLogger(historyRepository);
    }

}
