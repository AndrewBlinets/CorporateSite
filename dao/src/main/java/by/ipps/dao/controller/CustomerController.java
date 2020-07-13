package by.ipps.dao.controller;

import by.ipps.dao.dto.*;
import by.ipps.dao.entity.Customer;
import by.ipps.dao.entity.Project;
import by.ipps.dao.entity.UserPortal;
import by.ipps.dao.service.CustomerService;
import by.ipps.dao.service.ProjectService;
import by.ipps.dao.service.RoleService;
import by.ipps.dao.utils.constant.FilterName;
import by.ipps.dao.utils.view.ViewCustomer;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.Session;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Transactional
public class CustomerController {

  private ProjectService projectService;
  private CustomerService customerService;
  private ModelMapper modelMapper;
  private RoleService roleService;

  public CustomerController(
      CustomerService customerService,
      ProjectService projectService,
      ModelMapper modelMapper,
      RoleService roleService) {
    this.projectService = projectService;
    this.customerService = customerService;
    this.modelMapper = modelMapper;
    this.roleService = roleService;
  }

  @GetMapping(value = "/{customer}")
  public ResponseEntity<CustomerDtoForAdmin> get(@PathVariable Customer customer) {
    return (customer.getId() == 0 || !customer.getStatusR().equals("A"))
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(modelMapper.map(customer, CustomerDtoForAdmin.class), HttpStatus.OK);
  }

  @JsonView(ViewCustomer.BaseClass.class)
  @GetMapping
  public ResponseEntity<Page<Customer>> getAll(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable) {
    return new ResponseEntity<>(this.customerService.findPagingRecords(pageable), HttpStatus.OK);
  }

  @GetMapping(value = "/all")
  @ResponseBody
  @JsonView(ViewCustomer.BaseClass.class)
  public ResponseEntity<List<Customer>> getAll(
      @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Sort sort) {
    return new ResponseEntity<>(this.customerService.findAll(sort), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<CustomerDtoForAdmin> update(
          @RequestBody @Valid Customer entity, @RequestParam(value = "user") UserPortal userPortal) {
    Customer customer = customerService.findById(entity.getId());
    if (entity.getDateLastChangePassword() == null) {
      entity.setDateLastChangePassword(customer.getDateLastChangePassword());
    }
    if (entity.getHashPassword() == null) {
      entity.setHashPassword(customer.getHashPassword());
    }
    entity.setDateChangeStatusR(customer.getDateChangeStatusR());
    entity.setDti(customer.getDti());
    customer = customerService.update(entity);
    return new ResponseEntity<>(
        modelMapper.map(customer, CustomerDtoForAdmin.class), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CustomerDtoForAdmin> create(
          @RequestBody @Valid Customer entity, @RequestParam(value = "user") UserPortal userPortal) {
    entity.setRoles(new HashSet<>());
    entity.setEnabled(true);
    entity.setBlock(false);
    entity.getRoles().add(roleService.findById(5L));
    entity.setDateLastChangePassword(new Date());
    entity = customerService.create(entity);
    return entity != null
        ? new ResponseEntity<>(modelMapper.map(entity, CustomerDtoForAdmin.class), HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/project")
  @ResponseBody
  public ResponseEntity<List<ProjectDtoForCustomer>> getProjectPublicForCustomer() {
    List<Project> projects = projectService.findAllPublicForCustomer();
    java.lang.reflect.Type targetListType =
        new TypeToken<List<ProjectDtoForCustomer>>() {}.getType();
    List<ProjectDtoForCustomer> projectDtos = modelMapper.map(projects, targetListType);
    Comparator<ProjectDtoForCustomer> cmp =
        Comparator.comparing(ProjectDtoForCustomer::getShortTitle);
    projectDtos.sort(cmp);
    return new ResponseEntity<>(projectDtos, HttpStatus.OK);
  }

  @DeleteMapping(value = "/{customer}")
  public ResponseEntity<Boolean> remove(
          @PathVariable Customer customer, @RequestParam(value = "user") UserPortal userPortal)
      throws Exception {
    boolean flag = customerService.delete(customer);
    return flag
        ? new ResponseEntity<>(flag, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @PostMapping(value = "/authenticate")
  @ResponseBody
  public ResponseEntity<CustomerDto> authenticateCustomer(@RequestBody String login) {
    Customer customer = this.customerService.getCustomerByLogin(login);
    if (customer != null) {
      CustomerDto customerDto = this.modelMapper.map(customer, CustomerDto.class);
      return new ResponseEntity<>(customerDto, HttpStatus.OK);
    } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping(value = "/getInfoAboutCustomer")
  @ResponseBody
  public ResponseEntity<CustomerDtoFull> getInfoAboutCustomer(@RequestBody String login) {
    Customer customer = this.customerService.getCustomerByLogin(login);
    if (customer != null) {
      CustomerDtoFull customerDto = this.modelMapper.map(customer, CustomerDtoFull.class);
      return new ResponseEntity<>(customerDto, HttpStatus.OK);
    } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PersistenceContext private EntityManager entityManager;

  @GetMapping(value = "/favoriteProject")
  @ResponseBody
  public ResponseEntity<List<ProjectDtoForCustomerOne>> getFavoriteProject(
      @RequestParam("customer") Customer customer) {
    if (customer != null) {
      entityManager
          .unwrap(Session.class)
          .enableFilter(FilterName.LANGUAGE)
          .setParameter("language", "ru");
      List<Project> projects = customer.getFavoriteProject();
      java.lang.reflect.Type targetListType =
          new TypeToken<List<ProjectDtoForCustomerOne>>() {}.getType();
      List<ProjectDtoForCustomerOne> projectDto = this.modelMapper.map(projects, targetListType);
      for (ProjectDtoForCustomerOne project : projectDto) {
        project.setFavorites(true);
      }
      entityManager.unwrap(Session.class).disableFilter(FilterName.LANGUAGE);
      return new ResponseEntity<>(projectDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(value = "/favoriteProject")
  @ResponseBody
  public ResponseEntity<ProjectDtoForCustomerOne> addFavoriteProject(
      @RequestBody FavoriteProject favoriteProject) {
    try {
      Project project = projectService.findByIdAndPublicForCustomer(favoriteProject.getProject());
      Customer customer = this.customerService.findById(favoriteProject.getCustomer());
      if (customer.getProjects().contains(project)
          && !customer.getFavoriteProject().contains(project)) {
        customer.getFavoriteProject().add(project);
        this.customerService.update(customer);
      }
      entityManager
          .unwrap(Session.class)
          .enableFilter(FilterName.LANGUAGE)
          .setParameter("language", "ru");
      ProjectDtoForCustomerOne projectDto =
          this.modelMapper.map(project, ProjectDtoForCustomerOne.class);
      entityManager.unwrap(Session.class).disableFilter(FilterName.LANGUAGE);
      projectDto.setFavorites(true);
      return new ResponseEntity<>(projectDto, HttpStatus.OK);
    } catch (NullPointerException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping(value = "/favoriteProject/{project}")
  @ResponseBody
  public ResponseEntity deleteFavoriteProjefct(
          @RequestParam("customer") Customer customer, @PathVariable Project project) {
    try {
      customer.getFavoriteProject().remove(project);
      this.customerService.update(customer);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (NullPointerException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(value = "/customerProfail")
  @ResponseBody
  public ResponseEntity<CustomerDtoFull> updateCustomer(@RequestBody UserProfail userProfail) {
    Customer customer = this.customerService.findById(userProfail.getId());
    if (customer != null) {
      customer.setSurName(userProfail.getSurName());
      customer.setName(userProfail.getName());
      customer.setPatronicName(userProfail.getPatronicName());
      customer.setHashPassword(userProfail.getNewPassword());
      customer.setEmail(userProfail.getEmail());
      this.customerService.update(customer);
      CustomerDtoFull customerDto = this.modelMapper.map(customer, CustomerDtoFull.class);
      return new ResponseEntity<>(customerDto, HttpStatus.OK);
    } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/getList/{project}")
  @JsonView(ViewCustomer.BaseClass.class)
  public ResponseEntity<List<Customer>> getListCustomerWithoutProject(@PathVariable Project project) {
    return new ResponseEntity<>(this.customerService.getListCustomerWithoutProject(project.getCustomers()), HttpStatus.OK);
  }
}
