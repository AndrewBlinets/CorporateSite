package by.ipps.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
  protected String login;
  protected String hashPassword;
  protected Date dateLastChangePassword;
  protected String password;
  protected String name;
  protected String surName;
  protected String patronicName;
  protected Boolean enabled;
  protected Boolean block;
  protected String email;
  private List<ProjectForCustomer> projects;
  private List<PageForCustomer> sheets;
}
