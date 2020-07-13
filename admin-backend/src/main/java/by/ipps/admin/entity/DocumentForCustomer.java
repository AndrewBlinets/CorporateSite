package by.ipps.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DocumentForCustomer extends BaseEntity {

  private ProjectDtoAdmin project;
  private Page sheet;
  private byte[] file;
  private String fileName;
  private String description;
  private int size;
  private String mimeType;
  private FileManager fileManager;
}
