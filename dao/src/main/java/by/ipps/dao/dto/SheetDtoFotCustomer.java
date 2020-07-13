package by.ipps.dao.dto;

import by.ipps.dao.dto.sheet.BaseDto;
import by.ipps.dao.entity.PageLanguageVersion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SheetDtoFotCustomer extends BaseDto {
  private String name;

  public void setLanguageVersions(List<PageLanguageVersion> versions) {
    if (versions != null)
      if (!versions.isEmpty()) {
        for (PageLanguageVersion projectLanguageVersion : versions)
          if (projectLanguageVersion.getCodeLanguage().equals("ru")) {
            this.name = projectLanguageVersion.getName();
            break;
          }
      }
  }
}
