package by.ipps.dao.service.impl;

import by.ipps.dao.entity.Customer;
import by.ipps.dao.repository.CustomerRepository;
import by.ipps.dao.service.CustomerService;
import by.ipps.dao.service.base.BaseEntityServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer, CustomerRepository>
    implements CustomerService {

  public CustomerServiceImpl(CustomerRepository repository) {
    super(repository);
  }

  @Override
  public Customer getCustomerByLogin(String login) {
    return repository.findCustomerByLoginAndStatusR(login, "A").orElse(null);
  }

  @Override
  public List<Customer> findAllByIdCustomers(List<Long> customerList) {
    return repository.findAllByIdIn(customerList);
  }

  @Override
  public List<Customer> getListCustomerWithoutProject(List<Customer> customers) {
    List<Customer> list = repository.findAll();
    list.removeAll(customers);
    return list;
//    return null;
  }
}
