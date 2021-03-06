package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Logger;
import by.ipps.dao.service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LoggerController extends BaseEntityAbstractController<Logger, LoggerService>
    implements BaseEntityController<Logger> {

  protected LoggerController(LoggerService loggerService, ModelMapper modelMapper) {
    super(loggerService, modelMapper, loggerService);
  }
}
