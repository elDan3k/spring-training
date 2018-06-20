package pl.training.bank.account.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.training.bank.account.dto.AccountDto;
import pl.training.bank.account.entity.Account;
import pl.training.bank.account.services.AccountService;
import pl.training.bank.common.UriBuilder;
import pl.training.bank.common.aop.ResultPage;
import pl.training.bank.common.dto.PageDto;
import pl.training.bank.common.mapper.Mapper;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/accounts", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
@RestController
public class AccountController {

    @NonNull
    private Mapper mapper;
    @NonNull
    private AccountService accountService;
    private UriBuilder uriBuilder = new UriBuilder();

    //@Secured("Test")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount() {
        Account account = accountService.createAccount();
        URI uri = uriBuilder.requestUriWithId(account.getId());
        return ResponseEntity.created(uri).body(mapper.map(account, AccountDto.class));
    }

    @RequestMapping(value = "{number}", method = RequestMethod.GET)
    public AccountDto getByNumber(@PathVariable("number") String number) {
        Account account = accountService.getAccountByNumber(number);
        return mapper.map(account, AccountDto.class);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAccounts(@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        ResultPage<Account> accountsPage = accountService.getAccounts(pageNumber, pageSize);
        List<AccountDto> accountDtos = mapper.map(accountsPage.getData(), AccountDto.class);
        PageDto pageDto = new PageDto<>(accountDtos, accountsPage.getPageNumber(), accountsPage.getTotalPages());
        return ResponseEntity.ok(pageDto);
    }

    @RequestMapping(value = "{number}", method = RequestMethod.PUT)
    public ResponseEntity updateAccount(@RequestBody AccountDto accountDto, @PathVariable("number") String number) {
        if (!number.equals(accountDto.getNumber())) {
            return ResponseEntity.badRequest().build();
        }
        Account account = mapper.map(accountDto, Account.class);
        accountService.updateAccount(account);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "{number}" , method = RequestMethod.DELETE)
    public ResponseEntity deleteAccountByNunmber(@PathVariable("number") String number) {
        accountService.deleteAccount(number);
        return ResponseEntity.noContent().build();
    }

}
