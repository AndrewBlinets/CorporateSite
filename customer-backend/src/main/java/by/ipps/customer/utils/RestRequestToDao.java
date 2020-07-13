package by.ipps.customer.utils;

import by.ipps.customer.entity.CustomerAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestRequestToDao {

  @Value("${url.dao}")
  protected String URL_SERVER;

  public CustomerAuth getUserByLogin(String login) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<CustomerAuth> response =
        restTemplate.postForEntity(URL_SERVER + "customer/authenticate", login, CustomerAuth.class);
    return response.getBody();
  }
}
