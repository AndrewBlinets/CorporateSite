package by.ipps.client.controller;

import by.ipps.client.controller.base.BaseEntityAbstractController;
import by.ipps.client.controller.base.BaseEntityController;
import by.ipps.client.entity.Page;
import by.ipps.client.resttemplate.rest.PageRestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/page")
@CrossOrigin
public class PageController extends BaseEntityAbstractController<Page, PageRestTemplate>
    implements BaseEntityController<Page> {

  protected PageController(PageRestTemplate pageRestTemplate) {
    super(pageRestTemplate, "/page", "dti,ASC");
  }
}
