package utils;

/**
 * The StopWatch class provides functionality to measure elapsed time.
 * It allows starting and stopping the stopwatch, calculating the time difference,
 * and checking if a specified time has elapsed since the stopwatch started.
 */
public class StopWatch {

  private static long start;
  private static long end;

  /**
   * Starts the stopwatch by recording the current system time.
   */
  public static void start() {
    end = 0;
    start = System.currentTimeMillis();
  }

  /**
   * Stops the stopwatch by recording the current system time.
   *
   * @return the time difference in milliseconds between the start and stop times
   */
  public static long stop() {
    end = System.currentTimeMillis();
    return getDiff();
  }

  /**
   * Calculates the time difference in milliseconds between the start and stop times.
   *
   * @return the time difference in milliseconds
   */
  public static long getDiff() {
    return end - start;
  }

  /**
   * Checks if the stopwatch has executed for less than the specified number of milliseconds.
   *
   * @param millis the maximum elapsed time in milliseconds
   * @return true if the elapsed time is less than the specified milliseconds, false otherwise
   */
  public static boolean executedBefore(long millis) {
    return (end - start) < millis;
  }
}

