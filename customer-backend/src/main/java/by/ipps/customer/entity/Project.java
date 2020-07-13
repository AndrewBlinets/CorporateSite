package by.ipps.customer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Project extends BaseEntity implements Serializable {
  private String title;
  private List<CustomerForProject> customers;
  private boolean favorites;
}
