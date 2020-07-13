package by.ipps.dao.service;

import by.ipps.dao.entity.Contact;
import by.ipps.dao.entity.UserPortal;
import by.ipps.dao.service.base.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public interface ContactService extends BaseEntityService<Contact> {
  Contact findByUser(UserPortal userPortal);
}
