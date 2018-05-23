package pl.training.bank.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.training.bank.common.ResultPage;

@AllArgsConstructor
@Controller
public class AccountController {

    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "create-account.html")
    public String createAccount() {
        accountService.createAccount();
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "accounts.html")
    public ModelAndView showAccounts(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        ResultPage<Account> resultPage = accountService.getAccounts(pageNumber, pageSize);
        ModelAndView modelAndView = new ModelAndView("accounts");
        modelAndView.addObject("accountsPage", resultPage);
        return modelAndView;
    }

}
