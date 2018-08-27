package pl.training.bank.disposition;

import lombok.Setter;

public class LargeDepositLogger {

    @Setter
    private int maxDepositLimit = 1_000_000;

    public void checkDepositSize(Disposition disposition) {
        if (disposition.getOperationName().equals("deposit") && disposition.getFunds() >= maxDepositLimit) {
            System.out.println("Large deposit on " + disposition.getAccountNumber() + " detected");
        }
    }

}
