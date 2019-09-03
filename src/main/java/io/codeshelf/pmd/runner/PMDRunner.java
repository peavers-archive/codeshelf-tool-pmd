package io.codeshelf.pmd.runner;

import io.codeshelf.pmd.service.ProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

/**
 * @author Chris Turner (chris@forloop.space)
 */
@Slf4j
@RequiredArgsConstructor
public class PMDRunner implements CommandLineRunner {

    private final ProcessService processService;

    @Override
    public void run(final String... strings) {
        try {
            processService.execute();
        } catch (final IOException | InterruptedException e) {
            log.error("something went wrong... {}", e.getMessage());
        }
    }
}
