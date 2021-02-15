package by.ipps.client.resttemplate.rest.impl;

import by.ipps.client.entity.Page;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.rest.PageRestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class PageTemplate extends AbstractBaseEntityRestTemplate<Page> implements PageRestTemplate {

  private static final String LANGUAGE = "language";

  @Override
  public ResponseEntity<Page> findById(
      Long id, String url, String language, String section, String department) {
    try {
      UriComponentsBuilder builder =
          UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "/client/" + id);
      builder.queryParam(LANGUAGE, language);
      return restTemplate.exchange(
          builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Page>() {});
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }
}
