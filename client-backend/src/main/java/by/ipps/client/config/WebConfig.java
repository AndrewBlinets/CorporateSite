package by.ipps.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
//        implements WebMvcConfigurer {
  //
  //  }@Bean
  ////  public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerCustomizer()
  // {
  ////    return container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
  ////  }
//  @Bean
//  public ConfigurableServletWebServerFactory webServerFactory() {
//    UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
//    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
//    return factory;
//  }

//  @Bean
//  public TomcatServletWebServerFactory containerFactory() {
//    return new TomcatServletWebServerFactory() {
//      @Override
//      protected void customizeConnector(Connector connector) {
//        int maxSize = 50000000;
//        super.customizeConnector(connector);
//        connector.setMaxPostSize(maxSize);
//        connector.setMaxSavePostSize(maxSize);
//        if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
//
//          ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
//          logger.info("Set MaxSwallowSize "+ maxSize);
//        }
//      }
//    };
//
//  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
