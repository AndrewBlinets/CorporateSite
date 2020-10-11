package by.ipps.admin.exception;

public class InvalidJwtAuthenticationException extends Throwable {
  public InvalidJwtAuthenticationException(String expiredOrInvalidJwtToken) {}
}
