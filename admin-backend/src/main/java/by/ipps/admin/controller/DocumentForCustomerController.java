package by.ipps.admin.controller;

import by.ipps.admin.controller.base.BaseEntityAbstractController;
import by.ipps.admin.controller.base.BaseEntityController;
import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.DocForCustomer;
import by.ipps.admin.utils.resttemplate.DocumentForCustomerRestTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documentForCustomer")
@CrossOrigin
public class DocumentForCustomerController
    extends BaseEntityAbstractController<DocForCustomer, DocumentForCustomerRestTemplate>
    implements BaseEntityController<DocForCustomer> {

  public DocumentForCustomerController(DocumentForCustomerRestTemplate departmentTemplate) {
    super(departmentTemplate, "documentForCustomer", "id,ASC");
  }

  @Override
  public ResponseEntity<DocForCustomer> get(
      Long id,
      String language,
      long department,
      long sheet,
      HttpServletRequest httpServletRequest) {
    return super.get(id, language, department, sheet, httpServletRequest);
  }

  @Override
  protected Long getUserID() {
    return super.getUserID();
  }

  @Override
  public ResponseEntity<DocForCustomer> update(
      DocForCustomer entity, HttpServletRequest httpServletRequest) {
    return super.update(entity, httpServletRequest);
  }

  @Override
  public ResponseEntity<Boolean> remove(Long id, HttpServletRequest httpServletRequest) {
    return super.remove(id, httpServletRequest);
  }

  @Override
  public ResponseEntity<CustomPage<DocForCustomer>> getAll(
      long page,
      int size,
      String sort,
      String language,
      long department,
      long sheet,
      HttpServletRequest httpServletRequest) {
    return super.getAll(page, size, sort, language, department, sheet, httpServletRequest);
  }

  @Override
  public ResponseEntity<List<DocForCustomer>> getAll(
      String language, long department, long sheet, HttpServletRequest httpServletRequest) {
    return super.getAll(language, department, sheet, httpServletRequest);
  }

  @GetMapping("/byProject/{project}")
  public ResponseEntity<CustomPage<DocForCustomer>> getAll(
      @RequestParam(value = "page", required = false, defaultValue = "0") long page,
      @RequestParam(value = "size", required = false, defaultValue = "10") int size,
      @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
      @PathVariable long project) {
    return this.baseEntityTemplate.getAllByProject(page, size, sort, project);
  }

  @GetMapping("/byProject/{project}/all")
  public ResponseEntity<List<DocForCustomer>> getAll(@PathVariable long project) {
    return this.baseEntityTemplate.getAllByProjectAll(project);
  }

  @GetMapping(value = "/download/{id}")
  public void getFile(
      @PathVariable long id, HttpServletResponse response, HttpServletRequest httpServletRequest)
      throws IOException {
    ResponseEntity<DocForCustomer> documentForCustomerR = this.baseEntityTemplate.download(id);
    DocForCustomer docForCustomer = documentForCustomerR.getBody();
    response.setContentType(Objects.requireNonNull(docForCustomer).getMimeType());
    response.setHeader(
        "Content-Disposition",
        "attachment; filename=" + Objects.requireNonNull(docForCustomer).getFileName());
    response.getOutputStream().write(Objects.requireNonNull(docForCustomer).getFile());
  }
}
