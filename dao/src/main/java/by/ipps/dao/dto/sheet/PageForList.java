package by.ipps.dao.dto.sheet;

import by.ipps.dao.entity.PageLanguageVersion;
import by.ipps.dao.utils.view.ViewDocumentForCustomer;
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
public class PageForList extends BaseDto {
  private int code;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private String name;

  private int status;

  public void setLanguageVersions(List<PageLanguageVersion> languageVersions) {
    if (!languageVersions.isEmpty()) this.name = languageVersions.get(0).getName();
  }
}
