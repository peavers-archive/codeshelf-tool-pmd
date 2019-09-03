package io.codeshelf.pmd.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** @author Chris Turner (chris@forloop.space) */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "codeshelf")
public class CodeshelfProperties {

  /** Should metrics be pushed to Firehose or not. */
  private boolean dry;

  /** Directory to run the tool in. */
  private String workingDir;
}
