package by.ipps.customer.controller;

import by.ipps.customer.controller.base.BaseEntityAbstractController;
import by.ipps.customer.controller.base.BaseEntityController;
import by.ipps.customer.custom.CustomPage;
import by.ipps.customer.entity.DocumentForCustomer;
import by.ipps.customer.resttemplate.DocumentForCustomerRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RequestMapping(value = "/api/document")
@CrossOrigin
@RestController
public class DocumentForCustomerController
    extends BaseEntityAbstractController<DocumentForCustomer, DocumentForCustomerRestTemplate>
    implements BaseEntityController<DocumentForCustomer> {

  protected DocumentForCustomerController(
      DocumentForCustomerRestTemplate documentForCustomerRestTemplate) {
    super(documentForCustomerRestTemplate, "/documentForCustomer", "id");
  }

  @GetMapping(value = "/download/{id}")
  public void getFile(
          @PathVariable long id, HttpServletResponse response, HttpServletRequest httpServletRequest)
      throws IOException {
    ResponseEntity<DocumentForCustomer> documentForCustomerR =
        this.baseEntityRestTemplate.download(
            id, this.getInfoFromToken(httpServletRequest));
    DocumentForCustomer documentForCustomer = documentForCustomerR.getBody();
    response.setContentType(Objects.requireNonNull(documentForCustomer).getMimeType());
    response.setHeader(
        "Content-Disposition",
        "attachment; filename=" + Objects.requireNonNull(documentForCustomer).getFileName());
    response.getOutputStream().write(Objects.requireNonNull(documentForCustomer).getFile());
  }

  @GetMapping("/byProject/{project}")
  @ResponseBody
  public ResponseEntity<CustomPage<DocumentForCustomer>> getPageByIdProject(
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @RequestParam(value = "size", required = false, defaultValue = "10") int size,
      @RequestParam(value = "sort", required = false) String sort,
      HttpServletRequest httpServletRequest,
      @PathVariable long project) {
    return baseEntityRestTemplate.findPagingRecordsByProject(
        page,
        size,
        sort == null ? this.sortDefault : sort,
        url + "/byProjectPage/",
        getInfoFromToken(httpServletRequest),
        project);
  }

  @GetMapping("/byProject/{project}/all")
  @ResponseBody
  public ResponseEntity<List<DocumentForCustomer>> getAllByIdProject(
          HttpServletRequest httpServletRequest, @PathVariable long project) {
    return baseEntityRestTemplate.findAllByProject(
        url + "/byProject/", getInfoFromToken(httpServletRequest), project);
  }

  @GetMapping("/bySheet/{sheet}")
  @ResponseBody
  public ResponseEntity<CustomPage<DocumentForCustomer>> getPageByIdSheet(
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @RequestParam(value = "size", required = false, defaultValue = "10") int size,
      @RequestParam(value = "sort", required = false) String sort,
      HttpServletRequest httpServletRequest,
      @PathVariable long sheet) {
    return baseEntityRestTemplate.findPagingRecordsBySheet(
        page,
        size,
        sort == null ? this.sortDefault : sort,
        url + "/bySheetPage/",
        getInfoFromToken(httpServletRequest),
        sheet);
  }

  @GetMapping("/bySheet/{sheet}/all")
  @ResponseBody
  public ResponseEntity<List<DocumentForCustomer>> getAllByIdSheet(
          HttpServletRequest httpServletRequest, @PathVariable long sheet) {
    return baseEntityRestTemplate.findAllBySheet(
        url + "/bySheet/", getInfoFromToken(httpServletRequest), sheet);
  }
}
