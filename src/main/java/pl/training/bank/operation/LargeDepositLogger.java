package pl.training.bank.operation;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import pl.training.bank.disposition.Disposition;

public class LargeDepositLogger implements ApplicationEventPublisherAware {

    private static final long LARGE_DEPOSIT = 9_000;

    private ApplicationEventPublisher publisher;

    public void onLargeDeposit(Disposition disposition) {
        if (disposition.getFunds() >= LARGE_DEPOSIT) {
            LargeDepositEvent largeDepositEvent = new LargeDepositEvent(this);
            largeDepositEvent.setDisposition(disposition);
            publisher.publishEvent(largeDepositEvent);
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

}
