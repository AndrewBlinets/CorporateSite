package by.ipps.admin.utils.resttemplate.impl;

import by.ipps.admin.entity.FileManager;
import by.ipps.admin.utils.resttemplate.FileManagerRestTemplate;
import by.ipps.admin.utils.resttemplate.base.AbstractBaseEntityRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class FileManagerTemplate extends AbstractBaseEntityRestTemplate<FileManager>
    implements FileManagerRestTemplate {
  @Override
  public ResponseEntity<HttpStatus> getById(long id, HttpServletResponse response) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "file/" + id);
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

  @Override
  public ResponseEntity<HttpStatus> getByIdRelize(long id, HttpServletResponse response) {
    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(URL_SERVER + "file/realize/" + id);
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
