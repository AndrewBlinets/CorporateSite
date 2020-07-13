package by.ipps.admin.controller;

import by.ipps.admin.controller.base.BaseEntityAbstractController;
import by.ipps.admin.controller.base.BaseEntityController;
import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.NewsForCustomer;
import by.ipps.admin.utils.resttemplate.NewsForCustomerRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsForCustomer")
@CrossOrigin
public class NewsForCustomerController extends BaseEntityAbstractController<NewsForCustomer, NewsForCustomerRestTemplate>
        implements BaseEntityController<NewsForCustomer> {
    protected NewsForCustomerController(NewsForCustomerRestTemplate newsForCustomerRestTemplate) {
        super(newsForCustomerRestTemplate, "/newsForCustomer", "id");
    }

    @GetMapping("/byProject/{project}")
    public ResponseEntity<CustomPage<NewsForCustomer>> getAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") long page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @PathVariable long project) {
        return this.baseEntityTemplate.getAllByProject(page, size, sort, project);
    }

    @GetMapping("/byProject/{project}/all")
    public ResponseEntity<List<NewsForCustomer>> getAll(@PathVariable long project) {
        return this.baseEntityTemplate.getAllByProjectAll(project);
    }
}
