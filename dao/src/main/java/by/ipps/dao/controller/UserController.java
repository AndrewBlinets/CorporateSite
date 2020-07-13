package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.dto.UserDto;
import by.ipps.dao.entity.Department;
import by.ipps.dao.entity.Sheet;
import by.ipps.dao.entity.UserPortal;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.service.UserService;
import by.ipps.dao.utils.view.ViewUserPortal;
import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends BaseEntityAbstractController<UserPortal, UserService>
    implements BaseEntityController<UserPortal> {

  protected UserController(
      UserService userService, ModelMapper modelMapper, LoggerService loggerService) {
    super(userService, modelMapper, loggerService);
  }

  @Transactional
  @PostMapping("/auth")
  @ResponseBody
  public ResponseEntity<UserDto> auth(@RequestBody String login) {
    UserPortal userPortal = baseEntityService.getUserByLogin(login);
    if (userPortal != null) {
      UserDto userDto = this.modelMapper.map(userPortal, UserDto.class);
      return new ResponseEntity<>(userDto, HttpStatus.OK);
    } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @Override
  @JsonView(ViewUserPortal.ById.class)
  public ResponseEntity<UserPortal> get(
      Long id, String language, Sheet sheet, Department department) {
    return super.get(id, language, sheet, department);
  }

  @Override
  @JsonView(ViewUserPortal.ById.class)
  public ResponseEntity<UserPortal> create(UserPortal entity, UserPortal userPortal) {
    return super.create(entity, userPortal);
  }

  @Override
  @JsonView(ViewUserPortal.ById.class)
  public ResponseEntity<UserPortal> update(UserPortal entity, UserPortal userPortal) {
    return super.update(entity, userPortal);
  }

  @Override
  @JsonView(ViewUserPortal.BaseClass.class)
  public ResponseEntity<Page<UserPortal>> getAll(
          Pageable pageable, String language, Sheet sheet, Department department) {
    return super.getAll(pageable, language, sheet, department);
  }

  @Override
  @JsonView(ViewUserPortal.BaseClass.class)
  public ResponseEntity<List<UserPortal>> getAll(Sort sort) {
    return super.getAll(sort);
  }

  //  @Get
}
