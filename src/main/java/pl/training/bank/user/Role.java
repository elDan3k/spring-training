package pl.training.bank.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Role implements GrantedAuthority {

    @GeneratedValue
    @Id
    private Long id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

}
