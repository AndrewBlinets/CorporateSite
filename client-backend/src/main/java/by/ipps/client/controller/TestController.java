package by.ipps.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
@Slf4j
public class TestController {

  @RequestMapping(value = "/**/{[path:[^\\.]*}")
  public String redirect(HttpServletRequest request) {
    // Forward to home page so that route is preserved.
    return "forward:/";
  }
}
