package by.ipps.admin.utils.resttemplate;

import by.ipps.admin.entity.Project;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface ProjectRestTemplate extends BaseEntityRestTemplate<Project> {
  ResponseEntity<Boolean> setCustomer(long project, List<Long> customers);

  ResponseEntity<Boolean> publicForClient(long project, boolean status);

  ResponseEntity<Boolean> publicForCustomer(long project, boolean status);
}
