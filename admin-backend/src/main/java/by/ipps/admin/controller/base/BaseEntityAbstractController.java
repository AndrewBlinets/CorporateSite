package by.ipps.admin.controller.base;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.BaseEntity;
import by.ipps.admin.entity.UserAuth;
import by.ipps.admin.utils.RestRequestToDao;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;

@Slf4j
public abstract class BaseEntityAbstractController<
        T extends BaseEntity, S extends BaseEntityRestTemplate<T>>
    extends BaseInfoForController implements BaseEntityController<T> {

  protected final S baseEntityTemplate;
  protected final String url;
  protected String sortDefault;

  @Autowired private RestRequestToDao restRequestToDao;

  protected BaseEntityAbstractController(S s, String url, String sortDefault) {
    this.baseEntityTemplate = s;
    this.url = url;
    this.sortDefault = sortDefault;
  }

  @CrossOrigin
  @Override
  public ResponseEntity<T> get(
      Long id,
      String language,
      long department,
      long sheet,
      HttpServletRequest httpServletRequest) {
    return baseEntityTemplate.findById(id, url, department, sheet);
  }

  @CrossOrigin
  @Override
  public ResponseEntity<T> create(T entity, HttpServletRequest httpServletRequest) {
    long idUser = getUserID();
    return baseEntityTemplate.create(entity, url, idUser);
  }

  protected Long getUserID() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = "";
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }
    UserAuth user = restRequestToDao.getUserByLogin(username);
    return user.getId();
  }

  @CrossOrigin
  @Override
  public ResponseEntity<T> update(T entity, HttpServletRequest httpServletRequest) {
    long idUser = getUserID();
    return baseEntityTemplate.update(entity, url, idUser);
  }

  @CrossOrigin
  @Override
  public ResponseEntity<Boolean> remove(Long id, HttpServletRequest httpServletRequest) {
    long idUser = getUserID();
    baseEntityTemplate.delete(id, url, idUser);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @CrossOrigin
  @Override
  public ResponseEntity<CustomPage<T>> getAll(
      long page,
      int size,
      String sort,
      String language,
      long department,
      long sheet,
      HttpServletRequest httpServletRequest) {
    return baseEntityTemplate.findPagingRecords(
        page,
        size,
        (sort == null || sort.equals("")) ? this.sortDefault : sort,
        language,
        url,
        department,
        sheet);
  }

  @CrossOrigin
  @Override
  public ResponseEntity<List<T>> getAll(
      String language, long department, long sheet, HttpServletRequest httpServletRequest) {
    return baseEntityTemplate.findAllEntity(language, url, department, sheet);
  }
}
