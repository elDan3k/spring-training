package pl.training.bank.disposition;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.training.bank.operation.*;

import javax.validation.Valid;

@RequestMapping("disposition.html")
@AllArgsConstructor
@Controller
public class DispositionController {

    private DispositionService dispositionService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDispositionForm() {
        ModelAndView modelAndView = new ModelAndView("disposition");
        modelAndView.addObject(new Disposition());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView process(@Valid Disposition disposition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("disposition");
        }
        dispositionService.process(disposition);
        return new ModelAndView("redirect:success.html");
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ModelAndView onInsufficientFundsException(InsufficientFundsException ex) {
        return new ModelAndView("error", "message", ex.getClass().getSimpleName());
    } 

}
