package by.ipps.dao.controller;

import by.ipps.dao.custom.CustomPage;
import by.ipps.dao.dto.DocumentForCustomerDto;
import by.ipps.dao.entity.*;
import by.ipps.dao.service.DocumentForCustomerService;
import by.ipps.dao.utils.view.ViewDocumentForCustomer;
import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/documentForCustomer")
@Transactional
public class DocumentForCustomerController {

  private DocumentForCustomerService documentForCustomerService;
  private ModelMapper modelMapper;

  public DocumentForCustomerController(
      DocumentForCustomerService documentForCustomerService, ModelMapper modelMapper) {
    this.documentForCustomerService = documentForCustomerService;
    this.modelMapper = modelMapper;
  }

  @GetMapping(value = "/{documentForCustomer}")
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<DocumentForCustomerDto> get(DocumentForCustomer documentForCustomer) {
    if (documentForCustomer.getId() != 0 && documentForCustomer.getStatusR().equals("A")) {
      return new ResponseEntity<>(
          modelMapper.map(documentForCustomer, DocumentForCustomerDto.class), HttpStatus.OK);
    } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "/download/{documentForCustomer}")
  @JsonView(ViewDocumentForCustomer.FileClass.class)
  public ResponseEntity<DocumentForCustomerDto> getFile(
      @PathVariable DocumentForCustomer documentForCustomer) {
    if (documentForCustomer != null) {
      return new ResponseEntity<>(
          modelMapper.map(documentForCustomer, DocumentForCustomerDto.class), HttpStatus.OK);
    } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<DocumentForCustomerDto> create(
      @RequestBody @Valid DocumentForCustomer entity,
      @RequestParam(value = "user") UserPortal userPortal) {
    DocumentForCustomer documentForCustomer = documentForCustomerService.create(entity);
    return documentForCustomer != null
        ? new ResponseEntity<>(
            modelMapper.map(documentForCustomer, DocumentForCustomerDto.class), HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @PutMapping
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<DocumentForCustomerDto> update(
      @RequestBody @Valid DocumentForCustomer entity,
      @RequestParam(value = "user") UserPortal userPortal) {
    DocumentForCustomer documentForCustomer = documentForCustomerService.update(entity);
    return documentForCustomer != null
        ? new ResponseEntity<>(
            modelMapper.map(documentForCustomer, DocumentForCustomerDto.class), HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping(value = "/{documentForCustomer}")
  public ResponseEntity<Boolean> remove(
      @PathVariable DocumentForCustomer documentForCustomer,
      @RequestParam(value = "user") UserPortal userPortal) {
    boolean flagDelete = documentForCustomerService.delete(documentForCustomer);
    return flagDelete
        ? new ResponseEntity<>(flagDelete, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @GetMapping
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  @ResponseBody
  public ResponseEntity<CustomPage<DocumentForCustomerDto>> getAll(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @RequestParam(value = "section", required = false) Sheet sheet,
      @RequestParam(value = "department", required = false) Department department) {
    return getPageResponseEntity(documentForCustomerService.findPagingRecords(pageable));
  }

  @GetMapping(value = "/all")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<List<DocumentForCustomerDto>> getAll(
      @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Sort sort) {
    return getListResponseEntity(documentForCustomerService.findAll(sort));
  }

  @GetMapping("/byCustomerPage/{customer}")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<CustomPage<DocumentForCustomerDto>> getPageByIdCustomer(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @PathVariable Customer customer) {
    if (customer == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    if (!customer.getStatusR().equals("A")) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Page<DocumentForCustomer> page =
        this.documentForCustomerService.getDocumentForCustomerByIdCustomer(pageable, customer);
    return getPageResponseEntity(page);
  }

  @GetMapping("/byCustomer/{customer}")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<List<DocumentForCustomerDto>> getAllByIdCustomer(
      @PathVariable Customer customer) {
    if (customer == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    List<DocumentForCustomer> documentForCustomers = new ArrayList<>();
    for (Project project : customer.getProjects()) {
      documentForCustomers.addAll(project.getDocumentForCustomers());
    }
    for (Sheet sheet : customer.getSheets()) {
      documentForCustomers.addAll(sheet.getDocumentForCustomers());
    }
    return getListResponseEntity(documentForCustomers);
  }

  @GetMapping("/byProjectPage/{customer}/{project}")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<CustomPage<DocumentForCustomerDto>> getPageByIdProject(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @PathVariable Customer customer,
      @PathVariable Project project) {
    if (customer == null || project == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    if (!customer.getStatusR().equals("A") || !project.getStatusR().equals("A"))
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Page<DocumentForCustomer> page =
        this.documentForCustomerService.getDocumentForCustomerByIdProject(
            pageable, customer, project);
    return getPageResponseEntity(page);
  }

  @GetMapping("/byProject/{customer}/{project}")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<List<DocumentForCustomerDto>> getAllByIdProject(
          @PathVariable Customer customer, @PathVariable Project project) {
    if (customer == null || project == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    if (!customer.getStatusR().equals("A") || !project.getStatusR().equals("A"))
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    if (!customer.getProjects().contains(project))
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    List<DocumentForCustomer> documentForCustomers =
        this.documentForCustomerService.getDocumentForCustomerByIdProject(customer, project);
    return getListResponseEntity(documentForCustomers);
  }

  @GetMapping("/bySheetPage/{customer}/{sheet}")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<CustomPage<DocumentForCustomerDto>> getPageByIdSheet(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @PathVariable Customer customer,
      @PathVariable Sheet sheet) {
    if (customer == null || sheet == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    if (!customer.getStatusR().equals("A") || !sheet.getStatusR().equals("A"))
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Page<DocumentForCustomer> page =
        this.documentForCustomerService.getDocumentForCustomerByIdSheet(pageable, customer, sheet);
    return getPageResponseEntity(page);
  }

  private ResponseEntity<CustomPage<DocumentForCustomerDto>> getPageResponseEntity(
      Page<DocumentForCustomer> page) {
    java.lang.reflect.Type targetListType =
        new TypeToken<CustomPage<DocumentForCustomerDto>>() {}.getType();
    CustomPage<DocumentForCustomerDto> customPage = modelMapper.map(page, targetListType);
    return new ResponseEntity<>(customPage, HttpStatus.OK);
  }

  private ResponseEntity<List<DocumentForCustomerDto>> getListResponseEntity(
      List<DocumentForCustomer> list) {
    java.lang.reflect.Type targetListType =
        new TypeToken<List<DocumentForCustomerDto>>() {}.getType();
    List<DocumentForCustomerDto> listDto = modelMapper.map(list, targetListType);
    return new ResponseEntity<>(listDto, HttpStatus.OK);
  }

  @GetMapping("/bySheet/{customer}/{sheet}")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<List<DocumentForCustomerDto>> getAllByIdSheet(
          @PathVariable Customer customer, @PathVariable Sheet sheet) {
    if (customer == null || sheet == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    if (!customer.getStatusR().equals("A") || !sheet.getStatusR().equals("A"))
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    if (!customer.getSheets().contains(sheet)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    List<DocumentForCustomer> documentForCustomers =
        this.documentForCustomerService.getDocumentForCustomerByIdSheet(customer, sheet);
    return getListResponseEntity(documentForCustomers);
  }

  @GetMapping("/byProject/{project}")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<CustomPage<DocumentForCustomerDto>> getPageByIdProject(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @PathVariable Project project) {
    Page<DocumentForCustomer> page =
        this.documentForCustomerService.getDocumentForCustomerByProject(pageable, project);
    return getPageResponseEntity(page);
  }

  @GetMapping("/byProject/{project}/all")
  @ResponseBody
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  public ResponseEntity<List<DocumentForCustomerDto>> getAllByIdProject(
      @PathVariable Project project) {
    return getListResponseEntity(project.getDocumentForCustomers());
  }
}
