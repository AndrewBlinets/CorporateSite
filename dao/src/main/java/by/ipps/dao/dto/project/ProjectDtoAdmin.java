package by.ipps.dao.dto.project;

import by.ipps.dao.dto.sheet.BaseDto;
import by.ipps.dao.entity.ProjectLanguageVersion;
import by.ipps.dao.utils.view.ViewDocumentForCustomer;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDtoAdmin extends BaseDto implements Serializable {

  private Date datePublic;
  private Date dti;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private String shortTitle;

  private int status;
  private boolean publicForCustomer;
  private boolean publicForClient;

  public void setLanguageVersions(List<ProjectLanguageVersion> versions) {
    try {
      if (!versions.isEmpty()) {
        for (ProjectLanguageVersion projectLanguageVersion : versions)
          if (projectLanguageVersion.getCodeLanguage().equals("ru")) {
            this.shortTitle = projectLanguageVersion.getShortTitle();
            break;
          }
      }
    } catch (NullPointerException ignored) {
    }
  }
}
