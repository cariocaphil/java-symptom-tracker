package com.hemebiotech.analytics;


import java.util.logging.Logger;

/**
 *
 * a custom exception class for the case if a file to be read from should be empty
 */
public class EmptyFileException extends Exception {

  public static final Logger LOGGER = Logger.getLogger(EmptyFileException.class.getName());
  private static final String message = "The file is empty!";

  public EmptyFileException() {
    super(message);
  }
  /**
   *
   * simply logs the empty file message to the console
   */
  public void printStackTrace(String message) {
    LOGGER.info(message);
  }
}