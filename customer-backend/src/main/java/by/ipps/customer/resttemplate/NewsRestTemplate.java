package by.ipps.customer.resttemplate;

import by.ipps.customer.custom.CustomPage;
import by.ipps.customer.entity.News;
import by.ipps.customer.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsRestTemplate extends BaseEntityRestTemplate<News> {

  ResponseEntity<CustomPage<News>> findByIdProject(
          long project, int page, int size, String sort, long customer);

  ResponseEntity<List<News>> findByIdProject(long project, long customer);
}
