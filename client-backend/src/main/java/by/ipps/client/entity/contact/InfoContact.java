package by.ipps.client.entity.contact;

import by.ipps.client.entity.BaseEntity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoContact extends BaseEntity implements Serializable {
  private String note;
}
