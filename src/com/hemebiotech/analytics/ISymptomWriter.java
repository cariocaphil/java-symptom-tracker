package com.hemebiotech.analytics;


import java.io.IOException;

/**
 *
 * Anything that will write symptom data to an output file.
 *
 */

public interface ISymptomWriter {
  /**
   *
   * simply writes symptom data to an output file, no return value whatsoever.
   * @throws IOException if file cannot be written to
   */
  void writeSymptoms() throws IOException;
}
