package by.ipps.client.controller;

import by.ipps.client.entity.Partners;
import by.ipps.client.resttemplate.PartnersRestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partners")
@CrossOrigin
public class PartnersController {

  private final PartnersRestTemplate partnersRestTemplate;

  public PartnersController(PartnersRestTemplate partnersRestTemplate) {
    this.partnersRestTemplate = partnersRestTemplate;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<List<Partners>> getAllContact() {
    return partnersRestTemplate.getActualInfo();
  }
}
