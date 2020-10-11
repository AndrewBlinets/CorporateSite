package by.ipps.admin.utils.resttemplate;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.DocForCustomer;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface DocumentForCustomerRestTemplate
    extends BaseEntityRestTemplate<DocForCustomer> {
  ResponseEntity<CustomPage<DocForCustomer>> getAllByProject(
      long page, int size, String sort, long project);

  ResponseEntity<List<DocForCustomer>> getAllByProjectAll(long project);

  ResponseEntity<DocForCustomer> download(long id);
}
