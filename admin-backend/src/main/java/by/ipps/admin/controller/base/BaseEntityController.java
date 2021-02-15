package by.ipps.admin.controller.base;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.BaseEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BaseEntityController<T extends BaseEntity> {

  @CrossOrigin
  @PostMapping
  ResponseEntity<T> create(@RequestBody @Valid T entity, HttpServletRequest httpServletRequest);

  @CrossOrigin
  @GetMapping(value = "/{id}")
  ResponseEntity<T> get(
      @PathVariable Long id,
      @RequestParam(value = "language", required = false, defaultValue = "ru") String language,
      @RequestParam(value = "department", required = false, defaultValue = "0") long department,
      @RequestParam(value = "page", required = false, defaultValue = "0") long sheet,
      HttpServletRequest httpServletRequest);

  @CrossOrigin
  @PutMapping
  ResponseEntity<T> update(@RequestBody @Valid T entity, HttpServletRequest httpServletRequest);

  @CrossOrigin
  @DeleteMapping(value = "/{id}")
  ResponseEntity<Boolean> remove(@PathVariable Long id, HttpServletRequest httpServletRequest)
      throws Exception;

  @CrossOrigin
  @GetMapping
  ResponseEntity<CustomPage<T>> getAll(
      //          @AuthenticationPrincipal User user,
      @RequestParam(value = "page", required = false, defaultValue = "0") long page,
      @RequestParam(value = "size", required = false, defaultValue = "10") int size,
      @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
      @RequestParam(value = "language", required = false, defaultValue = "ru") String language,
      @RequestParam(value = "department", required = false, defaultValue = "0") long department,
      @RequestParam(value = "page", required = false, defaultValue = "0") long sheet,
      HttpServletRequest httpServletRequest);

  @CrossOrigin
  @GetMapping(value = "/all")
  ResponseEntity<List<T>> getAll(
      @RequestParam(value = "language", required = false, defaultValue = "ru") String language,
      @RequestParam(value = "department", required = false, defaultValue = "0") long department,
      @RequestParam(value = "page", required = false, defaultValue = "0") long sheet,
      HttpServletRequest httpServletRequest);
}
