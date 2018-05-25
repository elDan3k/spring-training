package pl.training.bank.user.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.bank.common.mapper.Mapper;
import pl.training.bank.user.dto.UserDto;

@RequiredArgsConstructor
@RequestMapping(value = "api/v1/users")
@RestController
public class UserController {

    @NonNull
    private Mapper mapper;

    @RequestMapping(value = "active", method = RequestMethod.GET)
    public UserDto getActiveUser(Authentication authentication) {
        return mapper.map(authentication.getPrincipal(), UserDto.class);
    }

}