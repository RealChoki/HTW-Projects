package utils;

import java.util.Scanner;

/**
 * The ReadUserInput class provides functionality to read user input from the console.
 */
public class ReadUserInput {
  /**
   * Reads a line of input entered by the user.
   *
   * @return the user's input as a String
   */
  public static String readUserInput() {
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    return userInput;
  }
}

