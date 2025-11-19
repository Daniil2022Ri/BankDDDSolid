package config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${app.version:1.0.0}")
    private String appVersion;

    @Value("${app.environment:local}")
    private String environment;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Информация о API
                .info(new Info()
                        .title("Anti-Fraud Service API")
                        .description("""
                            ## Микросервис для управления подозрительными транзакциями
                            
                            ### Основные возможности:
                            - Создание и управление подозрительными транзакциями карт, телефонов и аккаунтов
                            - Аудит всех изменений
                            - REST API для интеграции с другими сервисами
                            
                            ### Версия: %s
                            ### Окружение: %s
                            """.formatted(appVersion, environment))
                        .version(appVersion)
                        .contact(new Contact()
                                .name("")
                                .email("")
                                .url(""))
                        .license(new License()
                                .name("")
                                .url("")))

                .servers(List.of(
                        new Server()
                                .url("")
                                .description(""),
                        new Server()
                                .url("")
                                .description(""),
                        new Server()
                                .url("")
                                .description("")
                ))

                .components(new Components()
                        .addSecuritySchemes("", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("")
                                .bearerFormat("")
                                .description(""))
                )

                .addSecurityItem(new SecurityRequirement().addList(""));
    }
}
