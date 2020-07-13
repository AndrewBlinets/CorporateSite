package by.ipps.customer.resttemplate.base;

import by.ipps.customer.custom.CustomPage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseEntityRestTemplate<T> {

  ResponseEntity<T> findById(Long id, String url, int idCustomer);

  ResponseEntity<CustomPage<T>> findPagingRecords(
          long page, int size, String sort, String url, int idCustomer);

  ResponseEntity<List<T>> findAll(String url, int idCustomer);
}
