package by.ipps.dao.entity;

import by.ipps.dao.utils.view.ViewRole;
import by.ipps.dao.utils.view.ViewUserPortal;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity implements Serializable {

  @Column private String name;

  @JsonView({ViewRole.BaseClass.class, ViewUserPortal.ById.class})
  @Column
  private String statusName;

  @ManyToMany(mappedBy = "roles")
  private List<UserPortal> users;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append(super.toString());
    sb.append(", \"name\" : \"").append(name).append('\"');
    sb.append(", \"users\" : \"").append(users);
    sb.append("\"}");
    return sb.toString();
  }
}
