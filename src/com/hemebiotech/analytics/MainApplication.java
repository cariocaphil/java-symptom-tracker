package com.hemebiotech.analytics;

public class MainApplication {

  public static void main(String[] args) {

    AnalyticsCounter analyticsCounter = new AnalyticsCounter();
    analyticsCounter.readDataFromFile();
    analyticsCounter.countData();
    analyticsCounter.writeOutput();
  }
}
