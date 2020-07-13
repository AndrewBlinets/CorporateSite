package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.entity.Achievement;
import by.ipps.dao.service.AchievementService;
import by.ipps.dao.service.LoggerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/achievement")
public class AchievementController
    extends BaseEntityAbstractController<Achievement, AchievementService>
    implements BaseEntityController<Achievement> {
  protected AchievementController(
      AchievementService achievementService, ModelMapper modelMapper, LoggerService loggerService) {
    super(achievementService, modelMapper, loggerService);
  }
}
