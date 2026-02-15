package dev.prj.prjsredis001.infra.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.info")
public class InfoProperties {

  private String title;
  private String description;
  private String version;
  private String developers;

}
