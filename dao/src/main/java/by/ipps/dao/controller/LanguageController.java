package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Language;
import by.ipps.dao.service.LanguageService;
import by.ipps.dao.service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/language")
public class LanguageController extends BaseEntityAbstractController<Language, LanguageService>
    implements BaseEntityController<Language> {

  protected LanguageController(
      LanguageService languageService, ModelMapper modelMapper, LoggerService loggerService) {
    super(languageService, modelMapper, loggerService);
  }
}
