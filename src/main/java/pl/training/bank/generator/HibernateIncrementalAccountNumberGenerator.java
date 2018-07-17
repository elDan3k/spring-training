package pl.training.bank.generator;

import org.hibernate.SessionFactory;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Long.parseLong;

public class HibernateIncrementalAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String SELECT_LAST_ACCOUNT_NUMBER = "select max(a.number) from Account a";

    public HibernateIncrementalAccountNumberGenerator(SessionFactory sessionFactory) {
        sessionFactory.openSession().createQuery(SELECT_LAST_ACCOUNT_NUMBER, String.class)
                .uniqueResultOptional()
                .ifPresent(this::updateCounter);
    }

    private void updateCounter(String lastAccountNumber) {
        setCounter(new AtomicLong(parseLong(lastAccountNumber)));
    }

}
