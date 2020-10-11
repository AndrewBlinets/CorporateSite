package by.ipps.admin.utils.resttemplate;

import by.ipps.admin.entity.Customer;
import by.ipps.admin.entity.CustomerForList;
import by.ipps.admin.entity.ProjectForCustomer;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRestTemplate extends BaseEntityRestTemplate<Customer> {
  ResponseEntity<List<ProjectForCustomer>> findPublicProjectForCustomer();

  ResponseEntity<List<CustomerForList>> getListCustomerWithoutProject(long project);
}
