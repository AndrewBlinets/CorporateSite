package by.ipps.admin.utils.resttemplate;

import by.ipps.admin.entity.User;
import by.ipps.admin.entity.UserPortal;
import by.ipps.admin.utils.resttemplate.base.BaseEntityRestTemplate;
import org.springframework.stereotype.Component;

@Component
public interface UserRestTemplate extends BaseEntityRestTemplate<UserPortal> {
  User getUserByLogin(String login);
}
