package by.ipps.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectToBD extends BaseEntity implements Serializable {

  protected Date dti;
  protected Date datePublic;
  private List<ProjectLanguageVersion> languageVersions;
  private FileManager mainImage;
  private int countView;
  protected int status;
  private Department department;
  private Page page;
  private Boolean publicForCustomer;
  private Boolean publicForClient;

  public void setMainImage(long mainImage) {
    try {
      this.mainImage = new FileManager(mainImage);
    } catch (NullPointerException e) {
    }
  }
}
