package by.ipps.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity implements Serializable {
  //    private String login;
  //    private String hashPassword;
  private String name;
  protected String patronicName;
  protected String surName;
  private List<String> roles;
  private String email;
  private boolean enabled;
  private boolean block;
  private Org org;
  List<ProjectDtoForCustomer> projects;

  public Customer(String name, List<String> roles) {
    this.name = name;
    this.roles = roles;
  }
}
