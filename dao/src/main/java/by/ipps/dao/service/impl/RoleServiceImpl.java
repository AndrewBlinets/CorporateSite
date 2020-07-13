package by.ipps.dao.service.impl;

import by.ipps.dao.entity.Role;
import by.ipps.dao.repository.RoleRepository;
import by.ipps.dao.service.RoleService;
import by.ipps.dao.service.base.BaseEntityServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseEntityServiceImpl<Role, RoleRepository>
    implements RoleService {
  public RoleServiceImpl(RoleRepository repository) {
    super(repository);
  }
}
