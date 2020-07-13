package by.ipps.customer.resttemplate;

import by.ipps.customer.custom.CustomPage;
import by.ipps.customer.entity.DocumentForCustomer;
import by.ipps.customer.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DocumentForCustomerRestTemplate
    extends BaseEntityRestTemplate<DocumentForCustomer> {

  ResponseEntity<CustomPage<DocumentForCustomer>> findPagingRecordsByProject(
          int page, int size, String s, String url, int infoFromToken, long project);

  ResponseEntity<List<DocumentForCustomer>> findAllByProject(
          String url, int infoFromToken, long project);

  ResponseEntity<CustomPage<DocumentForCustomer>> findPagingRecordsBySheet(
          int page, int size, String s, String url, int infoFromToken, long sheet);

  ResponseEntity<List<DocumentForCustomer>> findAllBySheet(
          String url, int infoFromToken, long sheet);

    ResponseEntity<DocumentForCustomer> download(long id, int infoFromToken);
}
