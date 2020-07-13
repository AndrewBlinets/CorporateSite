package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Exhibitions;
import by.ipps.dao.service.ExhibitionsService;
import by.ipps.dao.service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exhibitions")
public class ExhibitionsController
    extends BaseEntityAbstractController<Exhibitions, ExhibitionsService>
    implements BaseEntityController<Exhibitions> {
  protected ExhibitionsController(
      ExhibitionsService exhibitionsService, ModelMapper modelMapper, LoggerService loggerService) {
    super(exhibitionsService, modelMapper, loggerService);
  }
}
