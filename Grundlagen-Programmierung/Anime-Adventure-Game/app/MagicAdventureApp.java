/**
 * The MagicAdventureApp class represents the main application for the Magic Adventure game.
 *
 * @author David Svoboda, Rafaat Choki
 */
package app;

import static java.util.Objects.nonNull;

import model.Magician;
import model.MasterWizard;
import spells.GumGum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static utils.ReadUserInput.readUserInput;

public class MagicAdventureApp {

  public static final String SAVE_FILE_NAME = "save";
  private MagicGame game;
  public static boolean gameRunning = true;

  /**
   * The main method of the application.
   * It displays a welcome message and initializes an instance of the MagicAdventureApp class.
   * It then enters a loop to continuously handle user input until the game is running.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    System.out.println("Welcome to the Magic Adventure game");
    System.out.println("========================================\n");

    MagicAdventureApp app = new MagicAdventureApp();

    while (gameRunning) {

      // if game is running
      if (app.hasRunningGame()) {
        MagicAdventureApp.runningGameMainMenu();
        String choice = readUserInput();
        app.handleInputRunningGame(choice);
        System.out.println("========================================");

      }

      // if game has been saved
      else if (app.hasSavedGame()) {
        app.savedGameMainMenu();
        String choice = readUserInput();
        app.handleInputSavedGame(choice);
        System.out.println("========================================");

      }

      // if game isn't running
      else if (!app.hasRunningGame()) {
        app.noGameMainMenu();
        String choice = readUserInput();
        app.handleInputNoRunningGame(choice);
        System.out.println("========================================");
      }

    }
  }

  /**
   * Starts a new game session.
   * It displays a brief introduction to the game's story and initializes the game with a new player character.
   * The player character is created using the MasterWizard class, and a GumGum spell is added to their spells list.
   * The game is then started by calling the run() method of the game instance.
   */
  private void startNewGame() {
    System.out.println("Luffy, the best student of Hogwards, is on his journey to free his dad from the tyranny of the most evil wizard the world has known, named Arlong.");
    System.out.println("Arlong has kidnapped several high-tier wizards, such as Monkey D. Dragonwhich is Luffy's dad, using his blue haki spell 'THE WATER!'");
    System.out.println();

    Magician player = MasterWizard.createMagician();
    player.buySpell(new GumGum());
    game = new MagicGame(player);
    game.runningGame = true;
    this.game.run();
  }

  /**
   * Displays the main menu for a running game.
   * It provides options for starting a new game, resuming the current game, saving the game, deleting the game, and quitting the application.
   * The user is prompted to choose a number between 1 and 5 to select an option.
   */
  public static void runningGameMainMenu() {
    System.out.println("You're in the main menu");
    System.out.println("What do you want to do next?");
    System.out.println("(1) Start new game");
    System.out.println("(2) Resume game");
    System.out.println("(3) Save game");
    System.out.println("(4) Delete game");
    System.out.println("(5) Quit");
    System.out.println("");
    System.out.println("Please choose a number between 1 and 5");
  }

  /**
   * Displays the main menu for a saved game.
   * It provides options for starting a new game, loading a saved game, deleting the game, and quitting the application.
   * The user is prompted to choose a number between 1 and 4 to select an option.
   */
  private void savedGameMainMenu() {
    System.out.println("You're in the main menu");
    System.out.println("What do you want to do next?");
    System.out.println("(1) Start new game");
    System.out.println("(2) Load game");
    System.out.println("(3) Delete game");
    System.out.println("(4) Quit");
    System.out.println("");
    System.out.println("Please choose a number between 1 and 4");
  }

  /**
   * Displays the main menu when no game is running.
   * It provides options for starting a new game or quitting the application.
   * The user is prompted to choose the number 1 or 2 to select an option.
   */
  private void noGameMainMenu() {
    System.out.println("You're in the main menu");
    System.out.println("Do you want to start a new game?");
    System.out.println("(1) Yes");
    System.out.println("(2) No");
    System.out.println("");
    System.out.println("Please choose the number 1 or 2");
  }

  

  /**
   * Handles the user input when a game is currently running.
   * It performs different actions based on the user's choice:
   * - 1: Start a new game
   * - 2: Continue the current game
   * - 3: Save the current game
   * - 4: Delete the current game
   * - 5: Quit the application
   *
   * @param input the user's input choice
   */
  private void handleInputRunningGame(String input) {
    switch (input) {
      case "1":
        this.startNewGame();
        break;
      case "2":
        this.continueGame();
        break;
      case "3":
        this.saveGame();
        break;
      case "4":
        this.deleteGame();
        break;
      case "5":
        gameRunning = false;
        break;
      default:
        System.out.println("The input '" + input + "' is invalid. Please choose a correct number between 1 and 5");
        break;
    }
  }

  /**
   * Handles the user input when a saved game is available.
   * It performs different actions based on the user's choice:
   * - 1: Start a new game
   * - 2: Load a saved game
   * - 3: Delete the saved game
   * - 4: Quit the application
   *
   * @param input the user's input choice
   */
  private void handleInputSavedGame(String input) {
    switch (input) {
      case "1":
        this.startNewGame();
        break;
      case "2":
        this.loadGame();
        break;
      case "3":
        this.deleteGame();
        break;
      case "4":
        gameRunning = false;
        break;
      default:
        System.out.println("The input '" + input + "' is invalid. Please choose a correct number between 1 and 4");
        break;
    }
  }

  /**
   * Handles the user input when no game is currently running.
   * It performs different actions based on the user's choice:
   * - 1: Start a new game
   * - 2: Quit the application
   *
   * @param input the user's input choice
   */
  private void handleInputNoRunningGame(String input) {
    switch (input) {
      case "1":
        this.startNewGame();
        break;
      case "2":
        gameRunning = false;
        break;
      default:
        System.out.println("The input '" + input + "' is invalid. Please choose the number 1 or 2");
        break;
    }
  }

  /**
   * Resumes the current game if it is already running.
   * If a game is running, it displays a message indicating that the game has been resumed and calls the run() method of the game instance.
   */
  private void continueGame() {
    if (!hasRunningGame()) {
      return;
    }
    System.out.println("Game resumed.");
    this.game.run();
  }

  /**
   * Deletes the saved game file.
   * If the file is successfully deleted, it displays a message indicating that the game has been deleted.
   */
  public void deleteGame() {
    if (new File(SAVE_FILE_NAME).delete()) {
      System.out.println("Game deleted!");
    }
  }

  /**
   * Saves the current game to a file.
   * It serializes the Magician object from the game instance and saves it to a file using ObjectOutputStream.
   * If the game is successfully saved, it displays a message indicating that the game has been saved.
   */
  private void saveGame() {
    try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(game.getMagician());
      oos.flush();
    } catch (Exception ex) {
      System.err.println("Something went wrong!" + ex);
      return;
    }
    System.out.println("Game saved!");
  }

  /**
   * Loads a saved game from a file.
   * It deserializes the Magician object from the saved file using ObjectInputStream and creates a new MagicGame instance with the loaded magician.
   * If the game is successfully loaded, the game instance is updated with the loaded game.
   */
  private void loadGame() {
    try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      this.game = new MagicGame((Magician) ois.readObject());
    } catch (Exception ex) {
      System.err.println("Something went wrong!" + ex);
    }
  }

  /**
   * Checks if a game is currently running.
   *
   * @return true if a game is running, false otherwise
   */
  private Boolean hasRunningGame() {
    return nonNull(game);
  }

  /**
   * Checks if a saved game exists.
   *
   * @return true if a saved game exists, false otherwise
   */
  private Boolean hasSavedGame() {
    return new File(SAVE_FILE_NAME).exists();
  }

}