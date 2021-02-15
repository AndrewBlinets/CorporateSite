package by.ipps.admin.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectLanguageVersion extends BaseEntity implements Serializable {

  private String title;
  private String shortTitle;
  private String content;
  private String codeLanguage;
}
