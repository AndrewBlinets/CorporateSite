package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Partners;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.service.PartnersService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partners")
public class PartnersController extends BaseEntityAbstractController<Partners, PartnersService>
    implements BaseEntityController<Partners> {

  protected PartnersController(
      PartnersService partnersService, ModelMapper modelMapper, LoggerService loggerService) {
    super(partnersService, modelMapper, loggerService);
  }
}
