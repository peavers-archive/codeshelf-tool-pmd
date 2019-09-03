package io.codeshelf.pmd;

import io.codeshelf.pmd.properties.CodeshelfProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@SpringBootApplication
@EnableConfigurationProperties(CodeshelfProperties.class)
public class Application {

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
