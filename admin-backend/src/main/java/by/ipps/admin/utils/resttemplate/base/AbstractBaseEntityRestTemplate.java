package by.ipps.admin.utils.resttemplate.base;

import by.ipps.admin.custom.CustomPage;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
public abstract class AbstractBaseEntityRestTemplate<E> implements BaseEntityRestTemplate<E> {

  @Value("${url.dao}")
  protected String URL_SERVER;

  private final Class<E> entityClass;

  @Autowired protected RestTemplate restTemplate;

  @SuppressWarnings("unchecked")
  public AbstractBaseEntityRestTemplate() {
    this.entityClass =
        (Class<E>)
            ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  @Override
  public ResponseEntity<E> findById(Long id, String url, long department, long sheet) {
    // TODO fix department
    return restTemplate.getForEntity(
        URL_SERVER + url + "/" + id, entityClass, new ParameterizedTypeReference<E>() {});
  }

  @Override
  public ResponseEntity<CustomPage<E>> findPagingRecords(
      long page, int size, String sort, String language, String url, long department, long sheet) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url)
            .queryParam("page", String.valueOf(page))
            .queryParam("size", String.valueOf(size))
            .queryParam("sort", sort)
            .queryParam("section", sheet)
            .queryParam("department", department)
            .queryParam("language", language);
    final ParameterizedTypeReference<CustomPage<E>> responseType =
        new ParameterizedTypeReference<CustomPage<E>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<E> create(E entity, String url, long idUser) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url)
            .queryParam("user", String.valueOf(idUser));
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<E> requestEntity = new HttpEntity<>(entity, requestHeaders);
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, entityClass);
  }

  @Override
  public ResponseEntity<E> update(E entity, String url, long idUser) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url)
            .queryParam("user", String.valueOf(idUser));
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<E> requestEntity = new HttpEntity<>(entity, requestHeaders);
    return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, requestEntity, entityClass);
  }

  @Override
  public ResponseEntity<Boolean> delete(long id, String url, long idUser) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "/" + id)
            .queryParam("user", String.valueOf(idUser));
    return restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null, Boolean.TYPE);
  }

  @Override
  public ResponseEntity<List<E>> findAllEntity(
      String language, String url, long department, long sheet) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "/all")
            .queryParam("section", sheet)
            .queryParam("department", department)
            .queryParam("language", language);
    final ParameterizedTypeReference<List<E>> responseType =
        new ParameterizedTypeReference<List<E>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }
}
