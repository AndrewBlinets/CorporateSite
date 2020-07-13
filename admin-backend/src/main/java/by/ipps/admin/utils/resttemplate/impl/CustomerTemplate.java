package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.entity.Customer;
import by.ipps.admin.entity.CustomerForList;
import by.ipps.admin.entity.ProjectForCustomer;
import by.ipps.admin.utils.resttemplate.CustomerRestTemplate;
import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class CustomerTemplate extends AbstractBaseEntityRestTemplate<Customer>
    implements CustomerRestTemplate {
  @Override
  public ResponseEntity<List<ProjectForCustomer>> findPublicProjectForCustomer() {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/customer/project");
    final ParameterizedTypeReference<List<ProjectForCustomer>> responseType =
        new ParameterizedTypeReference<List<ProjectForCustomer>>() {};
    ResponseEntity<List<ProjectForCustomer>> a =
        restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    return a;
  }

  @Override
  public ResponseEntity<List<CustomerForList>> getListCustomerWithoutProject(long project) {
    UriComponentsBuilder builder =
            UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/customer/getList/" + project);
    final ParameterizedTypeReference<List<CustomerForList>> responseType =
            new ParameterizedTypeReference<List<CustomerForList>>() {};
    ResponseEntity<List<CustomerForList>> a =
            restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    return a;
  }
}
