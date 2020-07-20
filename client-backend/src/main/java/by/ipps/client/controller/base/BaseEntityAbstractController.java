package by.ipps.client.controller.base;

import by.ipps.client.custom.CustomPage;
import by.ipps.client.entity.BaseEntity;
import by.ipps.client.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class BaseEntityAbstractController<
        T extends BaseEntity, S extends BaseEntityRestTemplate<T>>
    implements BaseEntityController<T> {

  protected final S baseEntityRestTemplate;
  protected String url;
  protected String sortDefault;

  protected BaseEntityAbstractController(S s, String url, String sortDefault) {
    this.baseEntityRestTemplate = s;
    this.url = url;
    this.sortDefault = sortDefault;
  }

  @Override
  public ResponseEntity<T> getById(
          Long id, HttpServletRequest request, String section, String department) {
    return baseEntityRestTemplate.findById(id, url, request.getHeader("Accept-Language"), section, department);
  }

  @Override
  public ResponseEntity<CustomPage<T>> getAllByPage(
      int page,
      int size,
      String sort,
      HttpServletRequest request,
      String section,
      String department) {
    return baseEntityRestTemplate.findPagingRecords(
        page, size, sort == null ? this.sortDefault : sort, request.getHeader("Accept-Language"), url, section, department);
  }

  @Override
  public ResponseEntity<List<T>> getAll(
          HttpServletRequest request, String section, String department) {
    return baseEntityRestTemplate.findAll(request.getHeader("Accept-Language"), url, section, department);
  }
}
