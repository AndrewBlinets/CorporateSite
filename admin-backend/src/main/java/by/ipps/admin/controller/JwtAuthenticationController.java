package by.ipps.admin.controller;

import by.ipps.admin.entity.JwtRequest;
import by.ipps.admin.entity.JwtResponse;
import by.ipps.admin.exception.AuthException;
import by.ipps.admin.utils.JwtTokenUtil;
import by.ipps.admin.utils.RestRequestToDao;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Log4j2
public class JwtAuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final RestRequestToDao restRequestToDao;

  public JwtAuthenticationController(
      AuthenticationManager authenticationManager,
      JwtTokenUtil jwtTokenUtil,
      RestRequestToDao restRequestToDao) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.restRequestToDao = restRequestToDao;
  }

  @PostMapping(value = "/api/authenticate")
  public ResponseEntity<JwtResponse> createAuthenticationToken(
      @RequestBody JwtRequest authenticationRequest,
      HttpServletRequest servletRequest,
      HttpServletResponse response) {
    log.info(getFrom(servletRequest, true));
    Cookie[] cookie2 = servletRequest.getCookies();
    if (cookie2 != null)
      for (Cookie cookie : cookie2) {
        log.info("---------------------------");
        log.info(cookie.getName());
        log.info(cookie.getValue());
        log.info("---------------------------");
      }
    getRequestHeadersInMap(servletRequest);
    try {
      authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    } catch (AuthException e) {
      return new ResponseEntity<>(new JwtResponse(null, e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
    Cookie cookie = new Cookie("username", "Jovan");
    // add cookie to response
    response.addCookie(cookie);
    return ResponseEntity.ok(
        new JwtResponse(
            jwtTokenUtil.generateToken(
                restRequestToDao.getUserByLogin(authenticationRequest.getUsername())),
            "Успешно авторизован!"));
  }

  private static final String[] IP_HEADER_CANDIDATES = {
    "X-Forwarded-For",
    "Proxy-Client-IP",
    "WL-Proxy-Client-IP",
    "HTTP_X_FORWARDED_FOR",
    "HTTP_X_FORWARDED",
    "HTTP_X_CLUSTER_CLIENT_IP",
    "HTTP_CLIENT_IP",
    "HTTP_FORWARDED_FOR",
    "HTTP_FORWARDED",
    "HTTP_VIA",
    "REMOTE_ADDR"
  };

  private static final Pattern PRIVATE_ADDRESS_PATTERN =
      Pattern.compile(
          "(^127\\.)|(^192\\.168\\.)|(^10\\.)|(^172\\.1[6-9]\\.)|(^172\\.2[0-9]\\.)|(^172\\.3[0-1]\\.)|(^::1$)|(^[fF][cCdD])",
          Pattern.CANON_EQ);

  public static String getFrom(HttpServletRequest request, boolean filterPrivateAddresses) {
    String remoteAddr = "";

    if (request != null) {
      remoteAddr = request.getHeader("X-FORWARDED-FOR");
      if (remoteAddr == null || "".equals(remoteAddr)) {
        remoteAddr = request.getRemoteAddr();
      }
    }

    return remoteAddr;
  }

  private Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

    Map<String, String> result = new HashMap<>();

    Enumeration headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = request.getHeader(key);
      log.info("---------------------------");
      log.info(key);
      log.info(value);
      log.info("---------------------------");
      result.put(key, value);
    }

    return result;
  }

  private static boolean isPrivateOrLocalAddress(String address) {
    Matcher regexMatcher = PRIVATE_ADDRESS_PATTERN.matcher(address);
    return regexMatcher.matches();
  }

  private void authenticate(String username, String password) throws AuthException {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password));
    } catch (LockedException e) {
      throw new AuthException("Пользователь заблокирован");
    } catch (DisabledException e) {
      throw new AuthException("Пользователь отключен");
    } catch (Exception e) {
      throw new AuthException("Неверный логин или пароль!");
    }
  }
}
