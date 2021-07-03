package pl.pjatk.jazs17818nbp.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30).select()
        .apis(RequestHandlerSelectors.withClassAnnotation(
            RestController.class))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
    return new ApiInfo("jaz-s17818-nbp", "Rest API for nbp service", "PJATK.1.0", null,
        new Contact("Sebastian Browarczyk", null, "s17818@pjwstk.edu.pll"), null, null,
        Collections.emptyList());
  }

}
