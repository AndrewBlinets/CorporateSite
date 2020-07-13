package by.ipps.admin.utils.resttemplate;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.DocumentForCustomer;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DocumentForCustomerRestTemplate
    extends BaseEntityRestTemplate<DocumentForCustomer> {
    ResponseEntity<CustomPage<DocumentForCustomer>> getAllByProject(long page, int size, String sort, long project);
    ResponseEntity<List<DocumentForCustomer>> getAllByProjectAll(long project);
    ResponseEntity<DocumentForCustomer> download(long id);
}
