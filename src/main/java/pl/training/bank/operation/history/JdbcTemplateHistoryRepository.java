package pl.training.bank.operation.history;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateHistoryRepository {

    private static final String INSERT_ENTRY = "insert into history (account_number,funds,operation_timestamp,operation_type) values (:accountNumber,:funds,:timestamp,:operationType)";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcTemplateHistoryRepository(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void save(HistoryEntry entry) {
        jdbcTemplate.update(INSERT_ENTRY, new BeanPropertySqlParameterSource(entry));
    }

}
