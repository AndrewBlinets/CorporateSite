package by.ipps.dao.entity;

import by.ipps.dao.utils.view.ViewFile;
import by.ipps.dao.utils.view.ViewProject;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class FileManager extends BaseEntity implements Serializable {

  @Column
  @JsonView({ViewFile.BaseClass.class, ViewFile.BaseClassRealize.class, ViewFile.FileClass.class, ViewProject.BaseForAdminClass.class})
  private String fileName;

  @Column
  @JsonView({ViewFile.BaseClass.class, ViewFile.BaseClassRealize.class, ViewFile.FileClass.class, ViewProject.BaseForAdminClass.class})
  private String fileMine;

  @Column
  @JsonView({ViewFile.BaseClass.class, ViewProject.BaseForAdminClass.class})
  private long size;

  @Column
  @JsonView({ViewFile.FileClass.class, ViewProject.BaseForAdminClass.class})
  private byte[] file;

  @Column
  @JsonView({ViewFile.BaseClassRealize.class, ViewProject.BaseForAdminClass.class})
  private byte[] realize;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("{");
    sb.append(super.toString());
    sb.append(", \"fileName\" : \"").append(fileName).append('\"');
    sb.append(", \"fileMine\" : \"").append(fileMine).append('\"');
    //    sb.append(", \"path\" : \"").append(path).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
