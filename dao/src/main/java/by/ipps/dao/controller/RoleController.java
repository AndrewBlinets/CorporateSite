package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Department;
import by.ipps.dao.entity.Role;
import by.ipps.dao.entity.Sheet;
import by.ipps.dao.entity.UserPortal;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.service.RoleService;
import by.ipps.dao.utils.view.ViewRole;
import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController extends BaseEntityAbstractController<Role, RoleService>
    implements BaseEntityController<Role> {
  protected RoleController(
      RoleService roleService, ModelMapper modelMapper, LoggerService loggerService) {
    super(roleService, modelMapper, loggerService);
  }

  @Override
  @JsonView(ViewRole.BaseClass.class)
  public ResponseEntity<Role> get(Long id, String language, Sheet sheet, Department department) {
    return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

  @Override
  @JsonView(ViewRole.BaseClass.class)
  public ResponseEntity<Role> create(Role entity, UserPortal userPortal) {
    return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

  @Override
  @JsonView(ViewRole.BaseClass.class)
  public ResponseEntity<Role> update(Role entity, UserPortal userPortal) {
    return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

  @Override
  @JsonView(ViewRole.BaseClass.class)
  public ResponseEntity<Page<Role>> getAll(
          Pageable pageable, String language, Sheet sheet, Department department) {
    return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

  @Override
  @JsonView(ViewRole.BaseClass.class)
  public ResponseEntity<List<Role>> getAll(Sort sort) {
    return super.getAll(sort);
  }
}
