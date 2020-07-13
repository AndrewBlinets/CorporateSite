package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.custom.CustomPage;
import by.ipps.dao.dto.ProjectDtoForCustomer;
import by.ipps.dao.dto.project.ProjectDto;
import by.ipps.dao.dto.project.ProjectDtoAdmin;
import by.ipps.dao.dto.project.ProjectDtoFull;
import by.ipps.dao.entity.*;
import by.ipps.dao.service.CustomerService;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.service.ProjectService;
import by.ipps.dao.utils.constant.FilterName;
import by.ipps.dao.utils.view.ViewProject;
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
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController extends BaseEntityAbstractController<Project, ProjectService>
    implements BaseEntityController<Project> {

  private ProjectService service;
  @PersistenceContext private EntityManager entityManager;
  private CustomerService customerService;

  protected ProjectController(
      ProjectService projectService,
      ModelMapper modelMapper,
      LoggerService loggerService,
      CustomerService customerService) {
    super(projectService, modelMapper, loggerService);
    this.service = projectService;
    this.customerService = customerService;
  }

  @GetMapping("/client")
  public ResponseEntity<CustomPage<ProjectDto>> getAllForClient(
      @PageableDefault() Pageable pageable,
      @RequestParam(value = "language", required = false, defaultValue = "ru") String language,
      @RequestParam(value = "section", required = false) Sheet sheet,
      @RequestParam(value = "department", required = false) Department department) {
    entityManager
        .unwrap(Session.class)
        .enableFilter(FilterName.LANGUAGE)
        .setParameter("language", language);
    Page<Project> projects =
        service.findProjectPageBySectionAndDepartment(sheet, department, pageable);
    java.lang.reflect.Type targetListType = new TypeToken<CustomPage<ProjectDto>>() {}.getType();
    CustomPage<ProjectDto> projectDto = this.modelMapper.map(projects, targetListType);
    entityManager.unwrap(Session.class).disableFilter(FilterName.LANGUAGE);
    return new ResponseEntity<>(projectDto, HttpStatus.OK);
  }

  @Transactional
  @GetMapping("/client/{id}")
  public ResponseEntity<ProjectDtoFull> getByIdForClient(
      @PathVariable Long id,
      @RequestParam(value = "language", required = false, defaultValue = "ru") String language,
      @RequestParam(value = "section", required = false) Sheet sheet,
      @RequestParam(value = "department", required = false) Department department) {
    entityManager
        .unwrap(Session.class)
        .enableFilter(FilterName.LANGUAGE)
        .setParameter("language", language);
    Project project = service.findByIdAndSectionAndDepartmentForClient(id, sheet, department);
    if (project != null) {
      ProjectDtoFull projectDtoFull = this.modelMapper.map(project, ProjectDtoFull.class);
      entityManager.unwrap(Session.class).disableFilter(FilterName.LANGUAGE);
      return new ResponseEntity<>(projectDtoFull, HttpStatus.OK);
    } else {
      entityManager.unwrap(Session.class).disableFilter(FilterName.LANGUAGE);
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/admin")
  public ResponseEntity<CustomPage<ProjectDtoAdmin>> getAllForAdmin(
      @PageableDefault() Pageable pageable,
      @RequestParam(value = "language", required = false, defaultValue = "ru") String language,
      @RequestParam(value = "section", required = false) Sheet sheet,
      @RequestParam(value = "department", required = false) Department department) {
    entityManager
        .unwrap(Session.class)
        .enableFilter(FilterName.LANGUAGE)
        .setParameter("language", language);
    Page<Project> news =
        service.findProjectPageBySectionAndDepartmentForAdmin(sheet, department, pageable);
    java.lang.reflect.Type targetListType =
        new TypeToken<CustomPage<ProjectDtoAdmin>>() {}.getType();
    CustomPage<ProjectDtoAdmin> newsDto = this.modelMapper.map(news, targetListType);
    entityManager.unwrap(Session.class).disableFilter(FilterName.LANGUAGE);
    return new ResponseEntity<>(newsDto, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Page<Project>> getAll(
          Pageable pageable, String language, Sheet sheet, Department department) {
    Page<Project> newsPage =
        service.findProjectPageBySectionAndDepartmentForAdmin(sheet, department, pageable);
    return new ResponseEntity<>(newsPage, HttpStatus.OK);
  }

  @Override
  @JsonView({ViewProject.BaseForAdminClass.class})
  public ResponseEntity<Project> get(Long id, String language, Sheet sheet, Department department) {
    Project news = service.findByIdAndSectionAndDepartment(id, sheet, department);
    return new ResponseEntity<>(news, news != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
  }

  @Override
  @JsonView({ViewProject.BaseForAdminClass.class})
  public ResponseEntity<Project> update(Project entity, UserPortal userPortal) {
    Project dataBaseVersion = service.findById(entity.getId());
    entity.setPublicForCustomer(dataBaseVersion.isPublicForCustomer());
//    entity.setPublicForClient(dataBaseVersion.isPublicForClient());
    entity.setStatusR(dataBaseVersion.getStatusR());
    entity.setDateChangeStatusR(dataBaseVersion.getDateChangeStatusR());
    entity.setDti(dataBaseVersion.getDti());
    for (ProjectLanguageVersion languageVersion : entity.getLanguageVersions()) {
      for (ProjectLanguageVersion languageVersionBase : dataBaseVersion.getLanguageVersions()) {
        if (languageVersionBase.getId() == languageVersion.getId()) {
          languageVersion.setDti(languageVersionBase.getDti());
          languageVersion.setDateChangeStatusR(languageVersionBase.getDateChangeStatusR());
        }
      }
    }
    ResponseEntity<Project> a =  super.update(entity, userPortal);
    return a;
  }

  @Override
  @JsonView({ViewProject.BaseForAdminClass.class})
  public ResponseEntity<Project> create(Project entity, UserPortal userPortal) {
    entity.setStatus(2);
    entity.setPublicForCustomer(false);
    return super.create(entity, userPortal);
  }

  @GetMapping(value = "/projectForCustomerByIdCustomer/{customer}")
  @ResponseBody
  public ResponseEntity<List<ProjectDtoForCustomer>> getProjectForCustomerByIdCustomer(
      @PathVariable Customer customer) {
    List<Project> projects = customer.getProjects();
    List<Project> favoriteProjects = customer.getFavoriteProject();
    java.lang.reflect.Type targetListType =
        new TypeToken<List<ProjectDtoForCustomer>>() {}.getType();
    List<ProjectDtoForCustomer> projectsDto = this.modelMapper.map(projects, targetListType);
    for (Project project : projects) {
      if (favoriteProjects.contains(project)) {
        for (ProjectDtoForCustomer projectDtoForCustomer : projectsDto) {
          if (projectDtoForCustomer.getId() == project.getId()) {
            projectDtoForCustomer.setFavorites(true);
            break;
          }
        }
      }
    }
    return projectsDto.isEmpty()
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(projectsDto, HttpStatus.OK);
  }

  @GetMapping(value = "/projectForCustomerById/{customer}/{project}")
  @ResponseBody
  public ResponseEntity<ProjectDtoForCustomer> getProjectForCustomerById(
          @PathVariable Customer customer, @PathVariable Project project) {
    if (project != null && customer != null) {
      ProjectDtoForCustomer projectsDto =
          this.modelMapper.map(project, ProjectDtoForCustomer.class);
      if (customer.getFavoriteProject().contains(project)) {
        projectsDto.setFavorites(true);
      }
      return new ResponseEntity<>(projectsDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(value = "/setCustomers/{project}")
  @Transactional
  public ResponseEntity<Boolean> setCustomers(
          @PathVariable Project project, @RequestBody List<Long> customerList) {
    try {
      List<Customer> customers = customerService.findAllByIdCustomers(customerList);
      for (Customer customer : customers) {
        if (!customer.getProjects().contains(project)) customer.getProjects().add(project);
      }
      if(!project.getCustomers().isEmpty()){
        project.setPublicForCustomer(true);
      } else {
        project.setPublicForCustomer(false);
      }
      return new ResponseEntity<>(true, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(value = "/byDepartmentPage")
  public ResponseEntity<CustomPage<ProjectDto>> getAllByDepartment(
      @PageableDefault()
          @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC),
          })
              Pageable pageable,
      @RequestBody List<Long> departments) {
    entityManager
            .unwrap(Session.class)
            .enableFilter(FilterName.LANGUAGE)
            .setParameter("language", "ru");
    Page<Project> projects =
            service.findProjectPageDepartmentId(departments, pageable);
    java.lang.reflect.Type targetListType = new TypeToken<CustomPage<ProjectDto>>() {}.getType();
    CustomPage<ProjectDto> projectDto = this.modelMapper.map(projects, targetListType);
    entityManager.unwrap(Session.class).disableFilter(FilterName.LANGUAGE);
    return new ResponseEntity<>(projectDto, HttpStatus.OK);
  }

//  @PostMapping(value = "/byDepartment")
//  public ResponseEntity<Project> getB(Long id, String language, Sheet sheet, Department department) {
//    Project news = service.findByIdAndSectionAndDepartment(id, sheet, department);
//    return new ResponseEntity<>(news, news != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
//  }

  @PostMapping("/publicForClient/{project}")
  public ResponseEntity<Boolean> setStatusProject(@PathVariable Project project, @RequestBody boolean status){
    try{
      project.setPublicForClient(status);
      return new ResponseEntity<>(true, HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/publicForCustomer/{project}")
  public ResponseEntity<Boolean> publicProjectForCusatomer(@PathVariable Project project, @RequestBody boolean status){
    try{
      project.setPublicForCustomer(status);
      return new ResponseEntity<>(true, HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
  }

}
