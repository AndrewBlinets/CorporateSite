package by.ipps.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentForCustomer extends BaseEntity {

  private Date dti;
  private ProjectDtoAdmin project;
  private PageForList sheet;
  private byte[] file;
  private String fileName;
  private String description;
  private long size;
  private String mimeType;
}
