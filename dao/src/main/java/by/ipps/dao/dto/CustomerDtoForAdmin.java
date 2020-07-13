package by.ipps.dao.dto;

import by.ipps.dao.dto.sheet.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDtoForAdmin extends BaseDto {
  protected String login;
  protected String name;
  protected String surName;
  protected String patronicName;
  protected Boolean enabled;
  protected Boolean block;
  protected String email;
  private List<ProjectDtoForCustomer> projects;
  private List<SheetDtoFotCustomer> sheets;
}
