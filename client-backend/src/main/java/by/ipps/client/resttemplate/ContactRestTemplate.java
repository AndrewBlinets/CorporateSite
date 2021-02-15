package by.ipps.client.resttemplate;

import by.ipps.client.entity.contact.ContactForClient;
import java.util.List;
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
public class ContactRestTemplate {

  @Value("url.dao")
  protected String URL_SERVER;

  protected final RestTemplate restTemplate;

  public ContactRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ResponseEntity<List<ContactForClient>> getActualInfo() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "contact/client");
    try {
      final ParameterizedTypeReference<List<ContactForClient>> responseType =
          new ParameterizedTypeReference<List<ContactForClient>>() {};
      return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      log.info("getContact");
      log.info(URL_SERVER);
      log.error(exception.getStatusCode() + " " + exception.getStatusText());
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }
}
