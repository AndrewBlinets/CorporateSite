package by.ipps.dao.service;

import by.ipps.dao.entity.Customer;
import by.ipps.dao.entity.DocumentForCustomer;
import by.ipps.dao.entity.Project;
import by.ipps.dao.entity.Sheet;
import by.ipps.dao.service.base.BaseEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentForCustomerService extends BaseEntityService<DocumentForCustomer> {
  Page<DocumentForCustomer> getDocumentForCustomerByIdCustomer(
          Pageable pageable, Customer customer);

  Page<DocumentForCustomer> getDocumentForCustomerByIdProject(
          Pageable pageable, Customer customer, Project project);

  List<DocumentForCustomer> getDocumentForCustomerByIdProject(Customer customer, Project project);

  Page<DocumentForCustomer> getDocumentForCustomerByIdSheet(
          Pageable pageable, Customer customer, Sheet sheet);

  List<DocumentForCustomer> getDocumentForCustomerByIdSheet(Customer customer, Sheet sheet);

  Page<DocumentForCustomer> getDocumentForCustomerByProject(Pageable pageable, Project project);
}
