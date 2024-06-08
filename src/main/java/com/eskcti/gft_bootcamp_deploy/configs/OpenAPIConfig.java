package com.eskcti.gft_bootcamp_deploy.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API do Bootcamp GFT 2024 com IA")
                        .version("1.0")
                        .description("Documentação da API do Bootcamp GFT 2024 com IA"));
    }
}
