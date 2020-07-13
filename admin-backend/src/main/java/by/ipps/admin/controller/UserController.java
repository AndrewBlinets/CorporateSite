package by.ipps.admin.controller;

import by.ipps.admin.controller.base.BaseEntityAbstractController;
import by.ipps.admin.controller.base.BaseEntityController;
import by.ipps.admin.entity.UserPortal;
import by.ipps.admin.utils.resttemplate.UserRestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseEntityAbstractController<UserPortal, UserRestTemplate>
    implements BaseEntityController<UserPortal> {

  protected UserController(UserRestTemplate userRestTemplate) {
    super(userRestTemplate, "/users", "id");
  }
}
