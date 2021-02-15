package by.ipps.client.controller;

import by.ipps.client.controller.base.BaseEntityAbstractController;
import by.ipps.client.controller.base.BaseEntityController;
import by.ipps.client.entity.Project;
import by.ipps.client.resttemplate.rest.ProjectRestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController extends BaseEntityAbstractController<Project, ProjectRestTemplate>
    implements BaseEntityController<Project> {

  protected ProjectController(ProjectRestTemplate projectRestTemplate) {
    super(projectRestTemplate, "/project/client", "dti,DESC");
  }
}
