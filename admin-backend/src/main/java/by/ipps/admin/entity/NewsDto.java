package by.ipps.admin.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto extends BaseEntity implements Serializable {

  private Date datePublic;
  private long mainImage;
  private int countView;
  private String shortTitle;
  private String entrySpeech;
}
