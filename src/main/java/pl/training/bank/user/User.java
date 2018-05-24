package pl.training.bank.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @GeneratedValue
    @Id
    private Long id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String role;
    private boolean enabled = true;

}
