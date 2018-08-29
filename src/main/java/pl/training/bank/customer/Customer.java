package pl.training.bank.customer;

import lombok.Data;
import pl.training.bank.account.entity.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

    @GeneratedValue
    @Id
    private Long id;
    private String lastName;
    private String firstName;
    @ManyToMany
    private List<Account> accounts = new ArrayList<>();

}
