package by.ipps.admin.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Language extends BaseEntity implements Serializable {

  private String nameLanguage;
  private String codeLanguage;
}
