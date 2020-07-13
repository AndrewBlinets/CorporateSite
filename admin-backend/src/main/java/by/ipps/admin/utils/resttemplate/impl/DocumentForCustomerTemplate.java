package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.DocumentForCustomer;
import by.ipps.admin.utils.resttemplate.DocumentForCustomerRestTemplate;
import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class DocumentForCustomerTemplate extends AbstractBaseEntityRestTemplate<DocumentForCustomer>
    implements DocumentForCustomerRestTemplate {
  @Override
  public ResponseEntity<CustomPage<DocumentForCustomer>> getAllByProject(
      long page, int size, String sort, long project) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/documentForCustomer/byProject/" + project)
            .queryParam("page", String.valueOf(page))
            .queryParam("size", String.valueOf(size))
            .queryParam("sort", sort);
    final ParameterizedTypeReference<CustomPage<DocumentForCustomer>> responseType =
        new ParameterizedTypeReference<CustomPage<DocumentForCustomer>>() {};
    ResponseEntity<CustomPage<DocumentForCustomer>> a =
        restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    return a;
  }

  @Override
  public ResponseEntity<List<DocumentForCustomer>> getAllByProjectAll(long project) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(
            URL_SERVER + "/documentForCustomer/byProject/" + project + "/all");
    final ParameterizedTypeReference<List<DocumentForCustomer>> responseType =
        new ParameterizedTypeReference<List<DocumentForCustomer>>() {};
    ResponseEntity<List<DocumentForCustomer>> a =
        restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    return a;
  }

  @Override
  public ResponseEntity<DocumentForCustomer> download(long id) {
    try {
      UriComponentsBuilder builder =
          UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/documentForCustomer/download/" + id);
      return restTemplate.exchange(
          builder.toUriString(),
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<DocumentForCustomer>() {});
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }
}
