package by.ipps.customer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class News extends BaseEntity {

  private Date date;
  private Date dti;
  private String title;
  private String content;
  private String shortTitle;
  private String entrySpeech;
  private FileManager mainImage;


  public void setDti(Date dti) {
    this.date = dti;
    this.dti = null;
  }
}
