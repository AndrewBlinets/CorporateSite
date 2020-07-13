package by.ipps.dao.repository;

import by.ipps.dao.entity.Contact;
import by.ipps.dao.entity.UserPortal;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends BaseEntityRepository<Contact> {
  Optional<Contact> findByUserPortal(UserPortal userPortal);
}
