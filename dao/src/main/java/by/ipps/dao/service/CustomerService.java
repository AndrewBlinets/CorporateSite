package by.ipps.dao.service;

import by.ipps.dao.entity.Customer;
import by.ipps.dao.service.base.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService extends BaseEntityService<Customer> {
  Customer getCustomerByLogin(String login);

    List<Customer> findAllByIdCustomers(List<Long> customerList);

    List<Customer> getListCustomerWithoutProject(List<Customer> customers);
}
