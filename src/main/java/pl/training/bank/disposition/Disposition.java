package pl.training.bank.disposition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.training.bank.common.Funds;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Disposition {

    @Pattern(regexp = "\\d{26}")
    private String accountNumber;
    @Funds(maxValue = 1_000)
    @Min(1)
    private long funds;
    private String operationName;

}
