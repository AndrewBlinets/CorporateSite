package by.ipps.client.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class News extends BaseEntity implements Serializable {
  private Date datePublic;
  private long mainImage;
  private int countView;
  private String shortTitle;
  private String entrySpeech;
  private String title;
  private String content;
}
