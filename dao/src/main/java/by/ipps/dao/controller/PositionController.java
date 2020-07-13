package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Department;
import by.ipps.dao.entity.Position;
import by.ipps.dao.entity.Sheet;
import by.ipps.dao.entity.UserPortal;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.service.PositionService;
import by.ipps.dao.utils.view.ViewPosition;
import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/position")
public class PositionController extends BaseEntityAbstractController<Position, PositionService>
    implements BaseEntityController<Position> {
  protected PositionController(
      PositionService positionService, ModelMapper modelMapper, LoggerService loggerService) {
    super(positionService, modelMapper, loggerService);
  }

  @Override
  @JsonView(ViewPosition.BaseClass.class)
  public ResponseEntity<Position> get(
      Long id, String language, Sheet sheet, Department department) {
    return super.get(id, language, sheet, department);
  }

  @Override
  @JsonView(ViewPosition.BaseClass.class)
  public ResponseEntity<Position> create(Position entity, UserPortal userPortal) {
    return super.create(entity, userPortal);
  }

  @Override
  @JsonView(ViewPosition.BaseClass.class)
  public ResponseEntity<Position> update(Position entity, UserPortal userPortal) {
    return super.update(entity, userPortal);
  }

  @Override
  @JsonView(ViewPosition.BaseClass.class)
  public ResponseEntity<Boolean> remove(Position id, UserPortal userPortal) {
    return super.remove(id, userPortal);
  }

  @Override
  @JsonView(ViewPosition.BaseClass.class)
  public ResponseEntity<Page<Position>> getAll(
          Pageable pageable, String language, Sheet sheet, Department department) {
    return super.getAll(pageable, language, sheet, department);
  }

  @Override
  @JsonView(ViewPosition.BaseClass.class)
  public ResponseEntity<List<Position>> getAll(Sort sort) {
    return super.getAll(sort);
  }
}
