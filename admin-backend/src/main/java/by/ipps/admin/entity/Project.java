package by.ipps.admin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project extends BaseEntity implements Serializable {

  protected Date dti;
  protected Date datePublic;
  private List<ProjectLanguageVersion> languageVersions;
  private long mainImage;
  private int status;
  private Department department;
  private Page page;
  private String shortTitle;
  private Boolean publicForCustomer;
  private Boolean publicForClient;

  public void setMainImage(BaseEntity mainImage) {
    try {
      this.mainImage = mainImage.getId();
    } catch (NullPointerException e) {
    }
  }
}
