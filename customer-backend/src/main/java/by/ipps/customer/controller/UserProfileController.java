package by.ipps.customer.controller;

import by.ipps.customer.controller.base.BaseInfoForController;
import by.ipps.customer.entity.CustomerAuth;
import by.ipps.customer.entity.UserProfail;
import by.ipps.customer.resttemplate.UserProfailRestTemplate;
import by.ipps.customer.utils.RestRequestToDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/userProfile")
@CrossOrigin
@Log4j2
public class UserProfileController extends BaseInfoForController {

  private final UserProfailRestTemplate userProfailRestTemplate;
  private final RestRequestToDao restRequestToDao;
  private final PasswordEncoder passwordEncoder;

  public UserProfileController(
          UserProfailRestTemplate userProfailRestTemplate, RestRequestToDao restRequestToDao, PasswordEncoder passwordEncoder) {
    this.userProfailRestTemplate = userProfailRestTemplate;
    this.restRequestToDao = restRequestToDao;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<String> saveChangeUserProfail(
          @RequestBody UserProfail userProfail, HttpServletRequest request) {
    log.info(userProfail.toString());
    CustomerAuth user =
        restRequestToDao.getUserByLogin(
            SecurityContextHolder.getContext().getAuthentication().getName());
    if (!passwordEncoder.matches(userProfail.getPassword(), user.getHashPassword()))
      return new ResponseEntity<>("Неверный текущий пароль", HttpStatus.UNAUTHORIZED);
    if (!userProfail.getNewPassword().equals("")) {
      userProfail.setNewPassword(passwordEncoder.encode(userProfail.getNewPassword()));
    } else userProfail.setNewPassword(user.getHashPassword());
    if (userProfail.getNewPassword().equals(userProfail.getPassword())
        || userProfail.getNewPassword().length() < 8)
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    if (userProfail.getId() != this.getInfoFromToken(request))
      return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    return userProfailRestTemplate.saveChange(userProfail);
  }
}
