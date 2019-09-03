package io.codeshelf.pmd.service;

import java.io.IOException;

/** @author Chris Turner (chris@forloop.space) */
public interface ProcessService {

  void execute() throws IOException, InterruptedException;
}
