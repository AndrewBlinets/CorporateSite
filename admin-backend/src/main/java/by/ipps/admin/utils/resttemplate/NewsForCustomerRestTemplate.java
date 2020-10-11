package by.ipps.admin.utils.resttemplate;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.NewsForCustomer;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface NewsForCustomerRestTemplate extends BaseEntityRestTemplate<NewsForCustomer> {
  ResponseEntity<CustomPage<NewsForCustomer>> getAllByProject(
      long page, int size, String sort, long project);

  ResponseEntity<List<NewsForCustomer>> getAllByProjectAll(long project);
}
