package by.ipps.customer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerForProject extends BaseEntity implements Serializable {
  private String name;
  private String surName;
  private String patronicName;
}
