package by.ipps.customer.resttemplate;

import by.ipps.customer.entity.UserProfail;
import by.ipps.customer.resttemplate.base.BaseInfoForRest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Component
public class UserProfailRestTemplate extends BaseInfoForRest {

  private static final String URL = "customer/customerProfail";

  public UserProfailRestTemplate(RestTemplate restTemplate) {
    super(restTemplate);
  }

  public ResponseEntity<String> saveChange(UserProfail userProfail) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.urlServer + URL);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<UserProfail> requestEntity = new HttpEntity<>(userProfail, requestHeaders);
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, String.class);
  }
}
