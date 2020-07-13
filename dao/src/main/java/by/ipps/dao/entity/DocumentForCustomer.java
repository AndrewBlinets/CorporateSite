package by.ipps.dao.entity;

import by.ipps.dao.utils.view.ViewDocumentForCustomer;
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
public class DocumentForCustomer extends BaseEntity {

  @JoinColumn
  @ManyToOne
  @JsonView({ViewDocumentForCustomer.FileClass.class})
  private Project project;

  @JoinColumn
  @ManyToOne
  @JsonView({ViewDocumentForCustomer.FileClass.class})
  private Sheet sheet;

  @ManyToOne
  @JoinColumn
  @JsonView({ViewDocumentForCustomer.FileClass.class})
  private FileManager fileManager;

  @Column
  @JsonView({ViewDocumentForCustomer.FileClass.class})
  private String description;
}
