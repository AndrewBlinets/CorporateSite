package by.ipps.customer.controller;

import by.ipps.customer.controller.base.BaseEntityAbstractController;
import by.ipps.customer.controller.base.BaseEntityController;
import by.ipps.customer.custom.CustomPage;
import by.ipps.customer.entity.News;
import by.ipps.customer.resttemplate.NewsRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin
public class NewsController extends BaseEntityAbstractController<News, NewsRestTemplate>
    implements BaseEntityController<News> {

  protected NewsController(NewsRestTemplate newsRestTemplate) {
    super(newsRestTemplate, "/news", "dti, asc");
  }

  @GetMapping("/byIdProjectPage/{project}")
  @ResponseBody
  public ResponseEntity<CustomPage<News>> getNewsByProiject(
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @RequestParam(value = "size", required = false, defaultValue = "10") int size,
      @RequestParam(value = "sort", required = false) String sort,
      @PathVariable long project,
      HttpServletRequest request) {
    return baseEntityRestTemplate.findByIdProject(
        project, page, size, sort, this.getInfoFromToken(request));
  }

  @GetMapping("/byIdProject/{project}")
  @ResponseBody
  public ResponseEntity<List<News>> getNewsByProiject(
          @PathVariable long project, HttpServletRequest request) {
    return baseEntityRestTemplate.findByIdProject(project, this.getInfoFromToken(request));
  }
}
