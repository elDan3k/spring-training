package pl.training.bank.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.training.bank.account.entity.Account;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDto {


    private String lastName;
    private String firstName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Account> accounts = new ArrayList<>();

}
