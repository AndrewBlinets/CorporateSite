package by.ipps.customer.controller.base;

import by.ipps.customer.custom.CustomPage;
import by.ipps.customer.entity.BaseEntity;
import by.ipps.customer.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class BaseEntityAbstractController<
        T extends BaseEntity, S extends BaseEntityRestTemplate<T>>
    extends BaseInfoForController implements BaseEntityController<T> {

  protected final S baseEntityRestTemplate;
  protected String url;
  protected String sortDefault;

  protected BaseEntityAbstractController(S s, String url, String sortDefault) {
    this.baseEntityRestTemplate = s;
    this.url = url;
    this.sortDefault = sortDefault;
  }

  @Override
  public ResponseEntity<T> getById(Long id, HttpServletRequest httpServletRequest) {
    return baseEntityRestTemplate.findById(id, url, getInfoFromToken(httpServletRequest));
  }

  @Override
  public ResponseEntity<CustomPage<T>> getAllByPage(
      int page, int size, String sort, HttpServletRequest httpServletRequest) {
    return baseEntityRestTemplate.findPagingRecords(
        page,
        size,
        sort == null ? this.sortDefault : sort,
        url,
        getInfoFromToken(httpServletRequest));
  }

  @Override
  public ResponseEntity<List<T>> getAll(HttpServletRequest httpServletRequest) {
    return baseEntityRestTemplate.findAll(url, getInfoFromToken(httpServletRequest));
  }
}
