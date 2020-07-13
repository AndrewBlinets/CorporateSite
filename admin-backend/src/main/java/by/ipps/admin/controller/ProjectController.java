package by.ipps.admin.controller;

import by.ipps.admin.controller.base.BaseEntityAbstractController;
import by.ipps.admin.controller.base.BaseEntityController;
import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.Department;
import by.ipps.admin.entity.Project;
import by.ipps.admin.utils.resttemplate.ProjectRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController extends BaseEntityAbstractController<Project, ProjectRestTemplate>
    implements BaseEntityController<Project> {

  protected ProjectController(ProjectRestTemplate projectTemplate) {
    super(projectTemplate, "/project", "dti,ASC");
  }

  @Override
  public ResponseEntity<Project> get(
      Long id,
      String language,
      long department,
      long sheet,
      HttpServletRequest httpServletRequest) {
    List<Long> departments = (List<Long>) this.getInfoFromToken(httpServletRequest, "Department");
//    if(department != null){
//
//    }
    return super.get(id, language, department, sheet, httpServletRequest);
  }

  @Override
  public ResponseEntity<Project> create(Project entity, HttpServletRequest httpServletRequest) {
    List<Long> departments = (List<Long>) this.getInfoFromToken(httpServletRequest, "Department");
    if (!departments.isEmpty())
      entity.setDepartment(new Department(Long.parseLong(String.valueOf(departments.get(0)))));
    return super.create(entity, httpServletRequest);
  }

  @Override
  public ResponseEntity<CustomPage<Project>> getAll(
      long page,
      int size,
      String sort,
      String language,
      long department,
      long sheet,
      HttpServletRequest httpServletRequest) {
    if(department == 0){
      List<Long> departments = (List<Long>) this.getInfoFromToken(httpServletRequest, "Department");
      if (!departments.isEmpty())
        department = Long.parseLong(String.valueOf(departments.get(0)));
    }
    return super.getAll(page, size, sort, language, department, sheet, httpServletRequest);
  }

  @Override
  public ResponseEntity<List<Project>> getAll(
      String language, long department, long sheet, HttpServletRequest httpServletRequest) {
    if(department == 0){
      List<Long> departments = (List<Long>) this.getInfoFromToken(httpServletRequest, "Department");
      if (!departments.isEmpty())
        department = Long.parseLong(String.valueOf(departments.get(0)));
    }
    return super.getAll(language, department, sheet, httpServletRequest);
  }

  @PostMapping(value = "/setCustomers/{project}")
  public ResponseEntity<Boolean> asd(
          HttpServletRequest request, @PathVariable long project, @RequestBody List<Long> customers) {
    return this.baseEntityTemplate.setCustomer(project, customers);
  }

  @PostMapping("/publicForClient/{project}")
  public ResponseEntity<Boolean> setStatusProject(@PathVariable long project, @RequestBody boolean status){
    return this.baseEntityTemplate.publicForClient(project, status);
  }

  @PostMapping("/publicForCustomer/{project}")
  public ResponseEntity<Boolean> publicProjectForCusatomer(@PathVariable long project, @RequestBody boolean status){
    return this.baseEntityTemplate.publicForCustomer(project, status);
  }
}
