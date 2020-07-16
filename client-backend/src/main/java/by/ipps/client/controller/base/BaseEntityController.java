package by.ipps.client.controller.base;

import by.ipps.client.custom.CustomPage;
import by.ipps.client.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface BaseEntityController<T extends BaseEntity> {

    @GetMapping(value = "/{id}")
    ResponseEntity<T> getById(@PathVariable Long id,
                              HttpServletRequest request,
                              @RequestParam(value = "pageId", required = false) String section,
                              @RequestParam(value = "Department", required = false) String department);

    @GetMapping
    ResponseEntity<CustomPage<T>> getAllByPage(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sort", required = false) String sort,
            HttpServletRequest request,
            @RequestParam(value = "pageId", required = false) String section,
            @RequestParam(value = "Department", required = false) String department);

    @GetMapping(value = "/all")
    @ResponseBody
    ResponseEntity<List<T>> getAll(
            HttpServletRequest request,
            @RequestParam(value = "pageId", required = false) String section,
            @RequestParam(value = "Department", required = false) String department);
}
