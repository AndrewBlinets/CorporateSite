package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.NewsForCustomer;
import by.ipps.admin.utils.resttemplate.NewsForCustomerRestTemplate;
import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class NewsForCustomerRestTemplateImpl extends AbstractBaseEntityRestTemplate<NewsForCustomer>
        implements NewsForCustomerRestTemplate {
    @Override
    public ResponseEntity<CustomPage<NewsForCustomer>> getAllByProject(long page, int size, String sort, long project) {
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/newsForCustomer/byProject/" + project)
                    .queryParam("page", String.valueOf(page))
                .queryParam("size", String.valueOf(size))
                .queryParam("sort", sort);
        final ParameterizedTypeReference<CustomPage<NewsForCustomer>> responseType =
                new ParameterizedTypeReference<CustomPage<NewsForCustomer>>() {};
        ResponseEntity<CustomPage<NewsForCustomer>> a =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
        return a;
    }

    @Override
    public ResponseEntity<List<NewsForCustomer>> getAllByProjectAll(long project) {
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/newsForCustomer/byProject/" + project + "/all").queryParam("sort", "dti,desc");
        final ParameterizedTypeReference<List<NewsForCustomer>> responseType =
                new ParameterizedTypeReference<List<NewsForCustomer>>() {};
        ResponseEntity<List<NewsForCustomer>> a =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
        return a;
    }
}
