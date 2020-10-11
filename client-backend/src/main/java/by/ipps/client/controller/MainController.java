package by.ipps.client.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping(value = "/**/{[path:[^\\.]*}")
  public String redirect(HttpServletRequest request) {
    // Forward to home page so that route is preserved.
    return "forward:/";
  }
}
