package by.ipps.client;

import by.ipps.client.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import(WebConfig.class)
public class ApplicationInitializer extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationInitializer.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(ApplicationInitializer.class);
  }
}
