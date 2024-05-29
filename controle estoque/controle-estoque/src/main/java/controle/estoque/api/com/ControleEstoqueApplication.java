package controle.estoque.api.com;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MC Contrução API",
		version = "1.0.0",
		description = "API desenvolvida para controle de estoque da MC Construção"))

public class ControleEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleEstoqueApplication.class, args);
	}

}
