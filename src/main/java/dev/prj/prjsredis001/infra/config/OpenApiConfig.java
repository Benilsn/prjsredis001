package dev.prj.prjsredis001.infra.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
  info = @Info(
    title = "Product API",
    version = "v1",
    description = "API for managing products",
    contact = @Contact(
      name = "Benilson Mtr",
      url = "https://github.com/Benilsn"
    ),
    license = @License(
      name = "Apache 2.0",
      url = "https://www.apache.org/licenses/LICENSE-2.0.html"
    )
  ),
  servers = {
    @Server(url = "http://localhost:8080", description = "Local development server")
  },
  tags = {
    @Tag(name = "Products", description = "Operations about products")
  }
)
public class OpenApiConfig {
}