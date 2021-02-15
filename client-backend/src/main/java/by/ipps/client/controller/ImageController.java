package by.ipps.client.controller;

import by.ipps.client.resttemplate.ImageRestTemplate;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
@CrossOrigin
public class ImageController {

  private final ImageRestTemplate imageRestTemplate;

  public ImageController(ImageRestTemplate imageRestTemplate) {
    this.imageRestTemplate = imageRestTemplate;
  }

  @GetMapping(value = "/{id}")
  @ResponseBody
  public ResponseEntity<HttpStatus> getImageById(
      @PathVariable long id, HttpServletResponse response) {
    return imageRestTemplate.getById(id, response);
  }

  @GetMapping(value = "/relize/{id}")
  @ResponseBody
  public ResponseEntity<HttpStatus> getByIdRelize(
      @PathVariable long id, HttpServletResponse response) {
    return imageRestTemplate.getByIdRelize(id, response);
  }
}
