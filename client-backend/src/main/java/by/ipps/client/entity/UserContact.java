package by.ipps.client.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContact extends BaseEntity implements Serializable {

  private String name;
  private String surName;
  private String patronicName;
  private String phone;
  private String room;
}
