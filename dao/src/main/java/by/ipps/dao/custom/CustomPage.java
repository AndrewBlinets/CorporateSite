package by.ipps.dao.custom;

import by.ipps.dao.utils.view.ViewDocumentForCustomer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomPage<T> {
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private List<T> content;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private long totalElements;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private int number;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private int size;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private int totalPages;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private int numberOfElements;
}
