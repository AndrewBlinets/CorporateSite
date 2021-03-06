package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.*;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.service.NewsForCustomerService;
import by.ipps.dao.utils.view.ViewNewsForCustomer;
import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/newsForCustomer")
public class NewsForCustomerController
    extends BaseEntityAbstractController<NewsForCustomer, NewsForCustomerService>
    implements BaseEntityController<NewsForCustomer> {

  protected NewsForCustomerController(
      NewsForCustomerService newsForCustomerService,
      ModelMapper modelMapper,
      LoggerService loggerService) {
    super(newsForCustomerService, modelMapper, loggerService);
  }

  @Override
  public ResponseEntity<Page<NewsForCustomer>> getAll(
          Pageable pageable, String language, Sheet sheet, Department department) {
    return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

  @Override
  public ResponseEntity<List<NewsForCustomer>> getAll(Sort sort) {
    return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

  @GetMapping("/byProject/{project}")
  @ResponseBody
  @JsonView(ViewNewsForCustomer.BaseForAdmin.class)
  public ResponseEntity<Page<NewsForCustomer>> getNewsByProiject(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @PathVariable Project project) {
    Page<NewsForCustomer> newsForCustomerPage =
        this.baseEntityService.findAllByProject(project, pageable);
    return new ResponseEntity<>(
        newsForCustomerPage, newsForCustomerPage != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/byProject/{project}/all")
  @ResponseBody
  @JsonView(ViewNewsForCustomer.BaseForAdmin.class)
  public ResponseEntity<List<NewsForCustomer>> getNewsByProiject(
      @PathVariable Project project,
      @SortDefault.SortDefaults({
            @SortDefault(sort = "dti", direction = Sort.Direction.DESC),
          })
              Sort sort) {
    List<NewsForCustomer> newsForCustomers = this.baseEntityService.findAllByProject(project,sort);
    return new ResponseEntity<>(
        newsForCustomers, newsForCustomers != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/byCustomerPage/{customer}")
  @ResponseBody
  public ResponseEntity<Page<NewsForCustomer>> getPageByIdCustomer(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @PathVariable Customer customer) {
    if (customer == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    if (!customer.getStatusR().equals("A")) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Page<NewsForCustomer> page =
        this.baseEntityService.getNewsForCustomerByIdCustomer(pageable, customer);
    return page.getContent().isEmpty()
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(page, HttpStatus.OK);
  }

  @GetMapping("/byCustomer/{customer}")
  @ResponseBody
  public ResponseEntity<List<NewsForCustomer>> getAllByIdCustomer(@PathVariable Customer customer) {
    if (customer == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    List<NewsForCustomer> newsForCustomers = new ArrayList<>();
    for (Project project : customer.getProjects()) {
      newsForCustomers.addAll(project.getNewsForCustomers());
    }
    for (Sheet sheet : customer.getSheets()) {
      newsForCustomers.addAll(sheet.getNewsForCustomers());
    }
    return new ResponseEntity<>(newsForCustomers, HttpStatus.OK);
  }
}
