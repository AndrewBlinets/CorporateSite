package by.ipps.client.resttemplate;

import by.ipps.client.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class AboutCompanyRestTemplate {
  @Value("url.dao")
  protected static String URL_SERVER;

  protected final RestTemplate restTemplate;

  public AboutCompanyRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ResponseEntity<Company> getActualInfo() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "company");
    try {
      final ParameterizedTypeReference<Company> responseType =
          new ParameterizedTypeReference<Company>() {};
      return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }
}
