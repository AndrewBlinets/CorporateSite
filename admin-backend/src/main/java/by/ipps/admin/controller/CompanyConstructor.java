package by.ipps.admin.controller;

import by.ipps.admin.entity.Company;
import by.ipps.admin.utils.resttemplate.impl.CompanyRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
@CrossOrigin
public class CompanyConstructor {

  private final CompanyRestTemplate restTemplate;

  public CompanyConstructor(CompanyRestTemplate companyService) {
    this.restTemplate = companyService;
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<Company> getInformationAboutCompany() {
    return restTemplate.getActualInfo();
  }

  @PostMapping
  public ResponseEntity<Company> setInformationAboutCompany(@RequestBody Company company) {
    return restTemplate.setActualInfo(company);
  }
}
