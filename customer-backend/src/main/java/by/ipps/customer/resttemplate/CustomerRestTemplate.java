package by.ipps.customer.resttemplate;

import by.ipps.customer.entity.Customer;
import by.ipps.customer.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRestTemplate extends BaseEntityRestTemplate<Customer> {
  ResponseEntity<Customer> getUserByLogin(String login);
}
