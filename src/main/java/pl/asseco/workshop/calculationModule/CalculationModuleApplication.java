package pl.asseco.workshop.calculationModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.asseco.workshop.calculationModule.Config.AppConfig;

@SpringBootApplication
public class CalculationModuleApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppConfig.class, args);

	}
}
