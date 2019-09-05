package io.codeshelf.pmd.runner;

import io.codeshelf.tool.executor.service.ProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.util.ArrayList;

/** @author Chris Turner (chris@forloop.space) */
@Slf4j
@RequiredArgsConstructor
public class ProcessRunner implements CommandLineRunner {

  private final ProcessService processService;

  @Value("${codeshelf.workingDir}")
  private String workingDir;

  @Value("${codeshelf.deliveryStream}")
  private String deliveryStream;

  @Override
  public void run(final String... strings) {

    final ArrayList<String> commands = new ArrayList<>();
    commands.add("pmd");
    commands.add("-dir");
    commands.add(workingDir);
    commands.add("-format");
    commands.add("xml");
    commands.add("-R");
    commands.add("rulesets/java/quickstart.xml");
    commands.add("-no-cache");

    try {
      processService.execute(commands, deliveryStream);
    } catch (final IOException | InterruptedException exception) {
      log.error("something went wrong... {}", exception.getMessage());
    }
  }
}
