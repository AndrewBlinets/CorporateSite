package by.ipps.admin.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page extends BaseEntity implements Serializable {
  private String name;
  private int code;
  private List<Section> sections;
  private int status;
}
