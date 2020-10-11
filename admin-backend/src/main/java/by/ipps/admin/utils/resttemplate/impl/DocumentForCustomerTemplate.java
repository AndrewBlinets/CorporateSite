package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.DocForCustomer;
import by.ipps.admin.utils.resttemplate.DocumentForCustomerRestTemplate;
import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class DocumentForCustomerTemplate extends AbstractBaseEntityRestTemplate<DocForCustomer>
    implements DocumentForCustomerRestTemplate {
  @Override
  public ResponseEntity<CustomPage<DocForCustomer>> getAllByProject(
      long page, int size, String sort, long project) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/documentForCustomer/byProject/" + project)
            .queryParam("page", String.valueOf(page))
            .queryParam("size", String.valueOf(size))
            .queryParam("sort", sort);
    final ParameterizedTypeReference<CustomPage<DocForCustomer>> responseType =
        new ParameterizedTypeReference<CustomPage<DocForCustomer>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<List<DocForCustomer>> getAllByProjectAll(long project) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(
            URL_SERVER + "/documentForCustomer/byProject/" + project + "/all");
    final ParameterizedTypeReference<List<DocForCustomer>> responseType =
        new ParameterizedTypeReference<List<DocForCustomer>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<DocForCustomer> download(long id) {
    try {
      UriComponentsBuilder builder =
          UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/documentForCustomer/download/" + id);
      return restTemplate.exchange(
          builder.toUriString(),
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<DocForCustomer>() {});
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }
}
