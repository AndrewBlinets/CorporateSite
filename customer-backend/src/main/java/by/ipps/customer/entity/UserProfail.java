package by.ipps.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfail extends BaseEntity implements Serializable {
  private String surName;
  private String name;
  private String patronicName;
  private String email;
  private String password;
  private String newPassword;
}
