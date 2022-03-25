package com.hemebiotech.analytics;


import java.util.logging.Logger;

public class EmptyFileException extends Exception {

  public static final Logger LOGGER = Logger.getLogger(EmptyFileException.class.getName());
  private static final String message = "The file is empty!";

  public EmptyFileException() {
    super(message);
  }

  public void printStackTrace(String message) {
    LOGGER.info(message);
  }
}