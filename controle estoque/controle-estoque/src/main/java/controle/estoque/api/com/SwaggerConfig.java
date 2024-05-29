package controle.estoque.api.com;

import java.util.Arrays;
import java.util.HashSet;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI detalheApi() {

        return new OpenAPI().components(new Components()).info(new Info()
                .version("1.0.0")
                .title("MC Construção")
                .description("Api criada para fazer o controle de estoque da MC Construção"));

        }
}