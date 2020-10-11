package by.ipps.admin.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionLanguageVersion extends BaseEntity {
  private String name;
  private List<BlockForFront> blocks;
  private String codeLanguage;
}
