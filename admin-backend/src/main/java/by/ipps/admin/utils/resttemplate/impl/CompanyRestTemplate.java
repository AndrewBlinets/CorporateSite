package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import by.ipps.admin.entity.Company;

@Component
public class CompanyRestTemplate extends AbstractBaseEntityRestTemplate<Company> {

  public ResponseEntity<Company> getActualInfo() {
    return restTemplate.getForEntity(URL_SERVER + "company", Company.class, Company.class);
  }

  public ResponseEntity<Company> setActualInfo(Company company) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "company");
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<Company> requestEntity = new HttpEntity<>(company, requestHeaders);
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, Company.class);
  }
}
