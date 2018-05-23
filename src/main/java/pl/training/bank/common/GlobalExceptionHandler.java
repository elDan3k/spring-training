package pl.training.bank.common;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.training.bank.account.AccountNotFoundException;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Setter
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ModelAndView onException(Exception ex, Locale locale) {
        return createResponse(ex, locale);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ModelAndView onAccountNotFoundException(AccountNotFoundException ex, Locale locale) {
        return createResponse(ex, locale);
    }

    private ModelAndView createResponse(Exception ex, Locale locale) {
        String exceptionName = ex.getClass().getSimpleName();
        String description;
        try {
            description = messageSource.getMessage(ex.getClass().getSimpleName(), null, locale);
        } catch (NoSuchMessageException exception) {
            description = exceptionName;

        }
        return new ModelAndView("error", "message", description);
    }

}
