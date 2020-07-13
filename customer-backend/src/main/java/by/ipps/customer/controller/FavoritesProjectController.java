package by.ipps.customer.controller;

import by.ipps.customer.controller.base.BaseInfoForController;
import by.ipps.customer.entity.FavoriteProject;
import by.ipps.customer.entity.Project;
import by.ipps.customer.resttemplate.FavoritesProjectRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/favorites")
@CrossOrigin
public class FavoritesProjectController extends BaseInfoForController {

  private final FavoritesProjectRestTemplate restTemplate;

  public FavoritesProjectController(FavoritesProjectRestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<List<Project>> getFavoritProject(HttpServletRequest request) {
    return restTemplate.getFavoritProjectByIdCustomer(this.getInfoFromToken(request));
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<Project> addProjectToFavorite(
          HttpServletRequest request, @RequestBody FavoriteProject favoriteProject) {
    favoriteProject.setCustomer(this.getInfoFromToken(request));
    return restTemplate.addFavoriteProject(favoriteProject);
  }

  @DeleteMapping("/{id}")
  public void removeFavoriteProject(HttpServletRequest request, @PathVariable long id) {
    restTemplate.removeFavoriteProject(this.getInfoFromToken(request), id);
  }
}
