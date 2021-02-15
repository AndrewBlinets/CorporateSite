package by.ipps.admin.utils.resttemplate;

import by.ipps.admin.entity.Section;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface SectionRestTemplate extends BaseEntityRestTemplate<Section> {
  ResponseEntity<List<Section>> findSectionByIdPage(long id);
}
