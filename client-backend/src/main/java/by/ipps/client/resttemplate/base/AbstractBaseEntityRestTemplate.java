package by.ipps.client.resttemplate.base;

import by.ipps.client.custom.CustomPage;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Log4j2
public abstract class AbstractBaseEntityRestTemplate<E> implements BaseEntityRestTemplate<E> {

  @Value("${url.dao}")
  protected static String URL_SERVER;
  private static final String LANGUAGE = "language";
  private static final String SECTION = "section";
  private static final String DEPARTAMENT = "department";

  @Autowired protected RestTemplate restTemplate;

  @Override
  public ResponseEntity<E> findById(
      Long id, String url, String language, String section, String department) {
    try {
      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "/" + id);
      setSectionAndDeportamentAndLanguage(language, section, department, builder);
      return restTemplate.exchange(
          builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<E>() {});
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }

  @Override
  public ResponseEntity<CustomPage<E>> findPagingRecords(
      long page,
      int size,
      String sort,
      String language,
      String url,
      String section,
      String department) {
    try {
      UriComponentsBuilder builder =
          UriComponentsBuilder.fromHttpUrl(URL_SERVER + url)
              .queryParam("page", String.valueOf(page))
              .queryParam("size", String.valueOf(size))
              .queryParam("sort", sort);
      setSectionAndDeportamentAndLanguage(language, section, department, builder);
      return restTemplate.exchange(
          builder.toUriString(),
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<CustomPage<E>>() {});
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }

  @Override
  public ResponseEntity<List<E>> findAll(
      String language, String url, String section, String department) {
    if (url.equals("/news/client"))
      return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    try {
      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "/all");
      setSectionAndDeportamentAndLanguage(language, section, department, builder);
      return restTemplate.exchange(
          builder.toUriString(),
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<List<E>>() {});
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }

  private void setSectionAndDeportamentAndLanguage(
      String language, String section, String department, UriComponentsBuilder builder) {
    if (language != null) builder.queryParam(LANGUAGE, language);
    if (section != null) builder.queryParam(SECTION, section);
    if (department != null) builder.queryParam(DEPARTAMENT, department);
  }
}
