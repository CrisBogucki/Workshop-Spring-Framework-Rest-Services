package pl.asseco.workshop.calculationModule.Config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by krzysztof.bogucki on 24 lip 2017.
 */
@Configuration
@ComponentScan("pl.asseco.workshop.calculationModule")
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.asseco.workshop.calculationModule.Controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Workshop Web Api Spring Framework Rest Full Services",
                "Web Api przygotowane na potrzeby prezentacji dla Asseco Poland SA.",
                "version 1.01.001",
                "Nasze warunki serwisu...",
                "krzysztof.bogucki@asseco.pl",
                "Licencje web api",
                "Adresy url do licencji...");
        return apiInfo;
    }


}
