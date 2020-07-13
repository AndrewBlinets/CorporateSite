package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Department;
import by.ipps.dao.entity.FileManager;
import by.ipps.dao.entity.Sheet;
import by.ipps.dao.entity.UserPortal;
import by.ipps.dao.service.FileManagerService;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.utils.view.ViewFile;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileManagerController
    extends BaseEntityAbstractController<FileManager, FileManagerService>
    implements BaseEntityController<FileManager> {

  protected FileManagerController(
      FileManagerService fileManagerService, ModelMapper modelMapper, LoggerService loggerService) {
    super(fileManagerService, modelMapper, loggerService);
  }

  @Override
  @JsonView({ViewFile.FileClass.class})
  public ResponseEntity<FileManager> get(
      Long id, String language, Sheet sheet, Department department) {
    return super.get(id, language, sheet, department);
  }

  @GetMapping(value = "/realize/{id}")
  @JsonView(ViewFile.BaseClassRealize.class)
  public ResponseEntity<FileManager> getRealize(
      @PathVariable Long id,
      @RequestParam(value = "language", required = false, defaultValue = "ru") String language,
      @RequestParam(value = "section", required = false) Sheet sheet,
      @RequestParam(value = "department", required = false) Department department) {
    return super.get(id, language, sheet, department);
  }

  @Override
  @JsonView(ViewFile.BaseClass.class)
  public ResponseEntity<FileManager> create(FileManager entity, UserPortal userPortal) {
    return super.create(entity, userPortal);
  }

  @Override
  @JsonView(ViewFile.BaseClass.class)
  public ResponseEntity<FileManager> update(FileManager entity, UserPortal userPortal) {
    return super.update(entity, userPortal);
  }

  @Override
  @JsonView(ViewFile.BaseClass.class)
  public ResponseEntity<Boolean> remove(FileManager id, UserPortal userPortal) {
    return super.remove(id, userPortal);
  }

  @Override
  @JsonView(ViewFile.BaseClass.class)
  public ResponseEntity<Page<FileManager>> getAll(
          Pageable pageable, String language, Sheet sheet, Department department) {
    return super.getAll(pageable, language, sheet, department);
  }

  @Override
  @JsonView(ViewFile.BaseClass.class)
  public ResponseEntity<List<FileManager>> getAll(Sort sort) {
    return super.getAll(sort);
  }
}
