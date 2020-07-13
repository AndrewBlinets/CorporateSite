package by.ipps.customer.resttemplate;

import by.ipps.customer.custom.CustomPage;
import by.ipps.customer.entity.News;
import by.ipps.customer.resttemplate.base.AbstractBaseEntityRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class NewsRestTemplateImp extends AbstractBaseEntityRestTemplate<News>
    implements NewsRestTemplate {

  public NewsRestTemplateImp(RestTemplate restTemplate) {
    super(restTemplate);
  }

  @Override
  public ResponseEntity<CustomPage<News>> findPagingRecords(
      long page, int size, String sort, String url, int idCustomer) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(urlServer + "newsForCustomer/byCustomerPage/" + idCustomer)
            .queryParam("page", String.valueOf(page))
            .queryParam("size", String.valueOf(size))
            .queryParam("sort", sort);
    final ParameterizedTypeReference<CustomPage<News>> responseType =
        new ParameterizedTypeReference<CustomPage<News>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<List<News>> findAll(String url, int idCustomer) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(urlServer + "newsForCustomer/byCustomer/" + idCustomer);
    final ParameterizedTypeReference<List<News>> responseType =
        new ParameterizedTypeReference<List<News>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<CustomPage<News>> findByIdProject(
      long project, int page, int size, String sort, long customer) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(urlServer + "newsForCustomer/byProject/" + project)
            .queryParam("page", String.valueOf(page))
            .queryParam("size", String.valueOf(size))
            .queryParam("sort", sort);
    final ParameterizedTypeReference<CustomPage<News>> responseType =
        new ParameterizedTypeReference<CustomPage<News>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<List<News>> findByIdProject(long project, long customer) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(urlServer + "newsForCustomer/byProject/" + project + "/all");
    final ParameterizedTypeReference<List<News>> responseType =
        new ParameterizedTypeReference<List<News>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }
}
