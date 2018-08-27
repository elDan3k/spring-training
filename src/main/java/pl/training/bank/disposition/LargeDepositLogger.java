package pl.training.bank.disposition;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LargeDepositLogger {

    private static final int MAX_DEPOSIT_SIZE = 1_000_000;

    @AfterReturning("execution(void pl.training.bank.disposition.DispositionService.process(..)) && args(disposition)")
    public void checkDepositSize(Disposition disposition) {
        if (disposition.getOperationName().equals("deposit") && disposition.getFunds() >= MAX_DEPOSIT_SIZE) {
            System.out.println("Large deposit on " + disposition.getAccountNumber() + " detected");
        }
    }

}
