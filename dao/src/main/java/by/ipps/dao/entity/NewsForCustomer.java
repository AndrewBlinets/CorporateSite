package by.ipps.dao.entity;

import by.ipps.dao.utils.view.ViewNewsForCustomer;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class NewsForCustomer extends BaseEntity {

  @JsonView(ViewNewsForCustomer.BaseForAdmin.class)
  @Column(length = 500)
  private String title;

  @JsonView(ViewNewsForCustomer.BaseForAdmin.class)
  @Column(length = 10000)
  private String content;

  @JsonView(ViewNewsForCustomer.BaseForAdmin.class)
  @Column(length = 500)
  private String shortTitle;

  @ManyToOne
  @JsonView(ViewNewsForCustomer.BaseForAdmin.class)
  @JoinColumn(name = "project_id", referencedColumnName = "id")
  private Project project;

  @ManyToOne
  @JsonView(ViewNewsForCustomer.BaseForAdmin.class)
  @JoinColumn(name = "sheet_id", referencedColumnName = "id")
  private Sheet sheet;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("NewsForCustomer{");
    sb.append("title='").append(title).append('\'');
    sb.append(", content='").append(content).append('\'');
    sb.append(", shortTitle='").append(shortTitle).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
