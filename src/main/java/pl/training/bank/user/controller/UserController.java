package pl.training.bank.user.controller;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.bank.common.mapper.Mapper;
import pl.training.bank.user.dto.UserDto;
import pl.training.bank.user.service.UserService;

import java.security.Principal;

@RequiredArgsConstructor
@NoArgsConstructor
@RequestMapping(value = "api/v1/users")
@RestController
public class UserController {

    @NonNull
    private UserService userService;
    @NonNull
    private Mapper mapper;

    @RequestMapping(value = "active", method = RequestMethod.GET)
    public UserDto getActiveUser(Principal principal) {
        UserDetails userDetails = userService.loadUserByUsername(principal.getName());
        return mapper.map(userDetails, UserDto.class);
    }

}