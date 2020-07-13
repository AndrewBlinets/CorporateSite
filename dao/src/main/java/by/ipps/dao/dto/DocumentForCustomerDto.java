package by.ipps.dao.dto;

import by.ipps.dao.dto.project.ProjectDtoAdmin;
import by.ipps.dao.dto.sheet.BaseDto;
import by.ipps.dao.dto.sheet.PageForList;
import by.ipps.dao.entity.FileManager;
import by.ipps.dao.utils.view.ViewDocumentForCustomer;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentForCustomerDto extends BaseDto {
  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private Date dti;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private ProjectDtoAdmin project;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private PageForList sheet;

  @JsonView(ViewDocumentForCustomer.FileClass.class)
  private byte[] file;

  @JsonView({ViewDocumentForCustomer.BaseClass.class, ViewDocumentForCustomer.FileClass.class})
  private String fileName;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private String description;

  @JsonView(ViewDocumentForCustomer.BaseClass.class)
  private long size;

  @JsonView(ViewDocumentForCustomer.FileClass.class)
  private String mimeType;

  public void setFile(FileManager file) {
    this.file = file.getFile();
    this.fileName = file.getFileName();
    this.size = file.getSize();
    this.mimeType = file.getFileMine();
  }
}
