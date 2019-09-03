package io.codeshelf.pmd.configuration;

import io.codeshelf.pmd.runner.PMDRunner;
import io.codeshelf.pmd.service.ProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author Chris Turner (chris@forloop.space) */
@Configuration
@RequiredArgsConstructor
public class RunnerConfig {

  private final ProcessService processService;

  @Bean
  public CommandLineRunner commandLineRunner() {
    return new PMDRunner(processService);
  }
}
