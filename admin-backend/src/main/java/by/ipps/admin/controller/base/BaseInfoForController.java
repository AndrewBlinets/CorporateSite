package by.ipps.admin.controller.base;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;

public class BaseInfoForController {

  @Value("${prefiks}")
  private String prefiks;

  @Value("${headre}")
  private String headre;

  @Value("${jwt.secret}")
  private String secretKey;

  protected Object getInfoFromToken(HttpServletRequest request, String nameField) {
    String jwtToken = request.getHeader(headre).replace(prefiks, "");
    Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
    return claims.get(nameField);
  }
}
