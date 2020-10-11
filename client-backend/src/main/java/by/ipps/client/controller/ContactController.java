package by.ipps.client.controller;

import by.ipps.client.entity.contact.ContactForClient;
import by.ipps.client.resttemplate.ContactRestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/contact")
public class ContactController {

  private final ContactRestTemplate contactRestTemplate;

  public ContactController(ContactRestTemplate contactRestTemplate) {
    this.contactRestTemplate = contactRestTemplate;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<List<ContactForClient>> getAllContact() {
    return contactRestTemplate.getActualInfo();
  }
}
