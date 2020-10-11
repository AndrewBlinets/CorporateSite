package by.ipps.admin.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewsLanguageVersion extends BaseEntity implements Serializable {

  private String title;
  private String content;
  private String shortTitle;
  private String entrySpeech;
  private String codeLanguage;
}
