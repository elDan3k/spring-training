package pl.training.bank;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.Environment;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.training.bank.account.AccountConfig;
import pl.training.bank.common.BeanLoggerPostProcessor;
import pl.training.bank.common.ContextListener;
import pl.training.bank.common.Profiler;
import pl.training.bank.disposition.DispositionConfig;
import pl.training.bank.operation.OperationConfig;

import javax.sql.DataSource;

import static java.lang.Integer.parseInt;

@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
@Import({AccountConfig.class, DispositionConfig.class, OperationConfig.class})
@EnableAspectJAutoProxy
@Configuration
public class BankConfig {

    @Bean
    public BeanLoggerPostProcessor beanLogger() {
        return new BeanLoggerPostProcessor();
    }

    @Bean
    public Profiler profiler() {
        return new Profiler();
    }

    @Bean
    public ContextListener contextListener() {
        return new ContextListener();
    }

    @Bean
    public ApplicationEventMulticaster eventMulticaster() {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return multicaster;
    }

    @Bean
    public DataSource dataSource(Environment environment) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setJdbcUrl(environment.getProperty("database.url"));
        dataSource.setDriverClassName(environment.getProperty("database.driver"));
        dataSource.setMaximumPoolSize(parseInt(environment.getProperty("database.max-pool-size")));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
