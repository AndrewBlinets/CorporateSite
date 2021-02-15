package by.ipps.client.resttemplate;

import by.ipps.client.entity.FileManager;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class ImageRestTemplate {
  @Value("url.dao")
  protected String URL_SERVER;

  protected final RestTemplate restTemplate;

  public ImageRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ResponseEntity<HttpStatus> getById(long id, HttpServletResponse response) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/file/" + id);
    try {
      ResponseEntity<FileManager> result =
          restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, FileManager.class);
      response.setContentType(Objects.requireNonNull(result.getBody()).getFileMine());
      response.setHeader(
          "Content-Disposition", "attachment; filename=" + result.getBody().getFileName());
      response.getOutputStream().write(result.getBody().getFile());
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  public ResponseEntity<HttpStatus> getByIdRelize(long id, HttpServletResponse response) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/realize/" + id);
    try {
      ResponseEntity<FileManager> result =
          restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, FileManager.class);
      response.setContentType(Objects.requireNonNull(result.getBody()).getFileMine());
      response.setHeader(
          "Content-Disposition", "attachment; filename=" + result.getBody().getFileName());
      response.getOutputStream().write(result.getBody().getRealize());
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
