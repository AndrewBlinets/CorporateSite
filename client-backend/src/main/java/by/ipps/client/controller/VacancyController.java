package by.ipps.client.controller;

import by.ipps.client.controller.base.BaseEntityAbstractController;
import by.ipps.client.controller.base.BaseEntityController;
import by.ipps.client.entity.Vacancy;
import by.ipps.client.resttemplate.rest.VacancyRestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vacancy")
@CrossOrigin
public class VacancyController extends BaseEntityAbstractController<Vacancy, VacancyRestTemplate>
    implements BaseEntityController<Vacancy> {

  protected VacancyController(VacancyRestTemplate vacancyRestTemplate) {
    super(vacancyRestTemplate, "/vacancy", "id");
  }
}
