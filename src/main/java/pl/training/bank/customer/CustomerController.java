package pl.training.bank.customer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.bank.account.dto.AccountDto;
import pl.training.bank.common.mapper.Mapper;

@RequestMapping("api/v1/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    @NonNull
    private CustomerService customerService;
    @NonNull
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = mapper.map(customerDto, Customer.class);
        customerService.addCustomer(customer);
        return ResponseEntity.notFound().build();
    }

    @RequestMapping("{id}/accounts")
    public ResponseEntity assignAccountToCustomer(@PathVariable("id") Long id, @RequestBody AccountDto accountDto) {
        customerService.assignAccount(id, accountDto.getId());
        return ResponseEntity.notFound().build();
    }


}
