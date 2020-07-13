package by.ipps.admin.controller;

import by.ipps.admin.controller.base.BaseEntityAbstractController;
import by.ipps.admin.controller.base.BaseEntityController;
import by.ipps.admin.entity.Customer;
import by.ipps.admin.entity.CustomerForList;
import by.ipps.admin.entity.ProjectForCustomer;
import by.ipps.admin.utils.resttemplate.CustomerRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController extends BaseEntityAbstractController<Customer, CustomerRestTemplate>
    implements BaseEntityController<Customer> {

  @Autowired
  private PasswordEncoder passwordEncoder;

  protected CustomerController(CustomerRestTemplate customerRestTemplate) {
    super(customerRestTemplate, "customer", "id");
  }

  @Override
  public ResponseEntity<Customer> create(Customer entity, HttpServletRequest httpServletRequest) {
    if (entity.getPassword() != null) {
      entity.setHashPassword(passwordEncoder.encode(entity.getPassword()));
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return super.create(entity, httpServletRequest);
  }

  @Override
  public ResponseEntity<Customer> update(Customer entity, HttpServletRequest httpServletRequest) {
    if (entity.getPassword() != null) {
      if (!entity.getPassword().equals("")) {
        entity.setDateLastChangePassword(new Date());
      } else {
        entity.setDateLastChangePassword(null);
      }
      entity.setHashPassword(passwordEncoder.encode(entity.getPassword()));
    }
    return super.update(entity, httpServletRequest);
  }

  @GetMapping("/publicProject")
  @ResponseBody
  public ResponseEntity<List<ProjectForCustomer>> getProjectPublicForCustomer() {
    return this.baseEntityTemplate.findPublicProjectForCustomer();
  }

  @GetMapping("/getList/{project}")
  public ResponseEntity<List<CustomerForList>> getListCustomerWithoutProject(@PathVariable long project) {
    return this.baseEntityTemplate.getListCustomerWithoutProject(project);
  }
}
