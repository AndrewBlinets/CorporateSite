package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.custom.CustomPage;
import by.ipps.admin.entity.Project;
import by.ipps.admin.entity.ProjectToBD;
import by.ipps.admin.utils.resttemplate.ProjectRestTemplate;
import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import java.util.Collections;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ProjectTemplate extends AbstractBaseEntityRestTemplate<Project>
    implements ProjectRestTemplate {

  @Autowired private ModelMapper modelMapper;

  @Override
  public ResponseEntity<CustomPage<Project>> findPagingRecords(
      long page, int size, String sort, String language, String url, long department, long sheet) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "project/admin")
            .queryParam("page", String.valueOf(page))
            .queryParam("size", String.valueOf(size))
            .queryParam("sort", sort)
            .queryParam("section", sheet)
            .queryParam("department", department)
            .queryParam("language", language);
    final ParameterizedTypeReference<CustomPage<Project>> responseType =
        new ParameterizedTypeReference<CustomPage<Project>>() {};
    return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
  }

  @Override
  public ResponseEntity<Project> create(Project entity, String url, long idUser) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url)
            .queryParam("user", String.valueOf(idUser));
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<ProjectToBD> requestEntity =
        new HttpEntity<>(modelMapper.map(entity, ProjectToBD.class), requestHeaders);
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, Project.class);
  }

  @Override
  public ResponseEntity<Project> update(Project entity, String url, long idUser) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + url)
            .queryParam("user", String.valueOf(idUser));
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<ProjectToBD> requestEntity =
        new HttpEntity<>(modelMapper.map(entity, ProjectToBD.class), requestHeaders);
    ResponseEntity<Project> a =
        restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, requestEntity, Project.class);
    return a;
  }

  @Override
  public ResponseEntity<Boolean> setCustomer(long project, List<Long> customers) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/project/setCustomers/" + project);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<List<Long>> requestEntity = new HttpEntity<>(customers, requestHeaders);
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, Boolean.class);
  }

  @Override
  public ResponseEntity<Boolean> publicForClient(long project, boolean status) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/project/publicForClient/" + project);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<Boolean> requestEntity = new HttpEntity<>(status, requestHeaders);
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, Boolean.class);
  }

  @Override
  public ResponseEntity<Boolean> publicForCustomer(long project, boolean status) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/project/publicForCustomer/" + project);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<Boolean> requestEntity = new HttpEntity<>(status, requestHeaders);
    return restTemplate.exchange(
        builder.toUriString(), HttpMethod.POST, requestEntity, Boolean.class);
  }
}
