package pl.training.bank.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
public class UserDto {

    private String login;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = Access.READ_ONLY)
    private Set<RoleDto> roles;

}