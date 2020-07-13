package by.ipps.customer.controller;

import by.ipps.customer.controller.base.BaseEntityAbstractController;
import by.ipps.customer.controller.base.BaseEntityController;
import by.ipps.customer.entity.Project;
import by.ipps.customer.resttemplate.ProjectRestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/project")
@CrossOrigin
public class ProjectController extends BaseEntityAbstractController<Project, ProjectRestTemplate>
    implements BaseEntityController<Project> {

  protected ProjectController(ProjectRestTemplate projectRestTemplate) {
    super(projectRestTemplate, "/project", "id");
  }
}
