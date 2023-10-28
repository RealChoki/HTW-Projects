import java.util.Scanner;

/**
 * Class with executable main method containing logic for the game "Hangman".
 */
public class Hangman {

    /**
     * Main method calling the main menu logic of Hangman.
     *
     * @param args Command line arguments (unused).
     * @author Team Prog1
     */
    public static void main(String[] args) {
        mainMenu();
    }

    /**
     * Displays the main menu for the Hangman game and handles user input for menu
     * options.
     * Tracks the number of wins and losses throughout the games.
     * 
     * @author Rafaat Choki
     */
    private static void mainMenu() {
        boolean isRunning = true;
        int wins = 0;
        int losses = 0;

        System.out.println("Welcome to Hangman !!");
        mainMenuOptions();

        while (isRunning) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch (input) {
                case "p":
                    boolean isGameWon = runGame();
                    if (isGameWon) {
                        wins++;
                        mainMenuOptions();
                    } else {
                        losses++;
                        mainMenuOptions();
                    }
                    System.out.println("Wins: " + wins + ", " + "Losses: " + losses);
                    break;
                case "q":
                    isRunning = false;
                    break;
                case "h":
                    listOfCommands();
                    break;
                default:
                    System.out.println("Invalid input '" + input + "'");
                    listOfCommands();
            }

        }

    }

    /**
     * Runs a game of Hangman and returns whether this game was lost or won by the
     * user.
     *
     * @return True if the game was won, false if not.
     * @author Team Prog1
     */
    private static boolean runGame() {
        final String randomWord = randomWord();
        final int maxWrongTurns = 5;
        int wrongTurns = 0;
        int foundCharacters = 0;
        String history = "";
        char[] wordLetters = initialCharArrayOfLength(randomWord.length());

        while (foundCharacters < randomWord.length() && wrongTurns < maxWrongTurns) {
            printRoundInfo(wordLetters, wrongTurns, maxWrongTurns);
            char characterInput = scanLetterCharToUpperCase();

            if (charExistsInArray(characterInput, history.toCharArray())) {
                System.out.println("'" + characterInput + "' has already been used, please try again.");
                continue;
            }

            history += characterInput;
            if (charExistsInArray(characterInput, randomWord.toCharArray())) {
                for (int i = 0; i < wordLetters.length; i++) {
                    if (randomWord.charAt(i) == characterInput) {
                        wordLetters[i] = characterInput;
                        foundCharacters++;
                    }
                }
            } else {
                wrongTurns++;
                printHangman(wrongTurns);
            }

        }

        boolean isGameWon = foundCharacters == wordLetters.length;
        System.out.print("You " + (isGameWon ? "won" : "lost") + " this round! Word was: " + randomWord + "\n");
        return isGameWon;
    }

    /**
     * Displays the main menu options for the game.
     * The user can start/quit the game, or seek help.
     * 
     * @author Rafaat Choki
     */
    private static void mainMenuOptions() {
        System.out.println("Do you want to start a new game (: --->    Press 'p'");
        System.out.println("Do you want to quit the game ): --->    Press 'q'");
        System.out.println("Do you need help O_o --->    Press 'h'");
    }

    /**
     * Displays a list of all the available commands.
     * Each command is described along with its corresponding key.
     * 
     * @author Rafaat Choki
     */
    private static void listOfCommands() {
        System.out.println("Here is a list of all the commands:");
        System.out.println("'p' ---> stands for (Play) - Starts new game");
        System.out.println("'q' ---> stands for (Quit) - Ends the game");
        System.out.println("'h' ---> stands for (Help) - lists all commands");
    }

    /**
     * Prints the information of a current Hangman round, i.e., the nr. of wrong
     * turns and the currently visible
     * word/underscores for letters yet to be guessed.
     *
     * @param word          (Partly hidden) word whose letters are to be guessed
     *                      represented as char array.
     * @param wrongTurns    Nr. of wrong turns for a current game.
     * @param maxWrongTurns Max nr. of wrong turns.
     * @author Team Prog1
     */
    private static void printRoundInfo(char[] word, int wrongTurns, int maxWrongTurns) {
        System.out.print("Word: ");
        System.out.print(word);
        System.out.println(" (Wrong turns: " + wrongTurns + "/" + maxWrongTurns + ")");

    }

    /**
     * Prints a visual representation of the hangman based on the number of wrong
     * turns.
     * 
     * @param wrongTurns The number of wrong turns made in the game.
     * @author Rafaat Choki
     */
    private static void printHangman(int wrongTurns) {
        String[] hangManArt = {
                "        +---+\n        |   |\n            |\n            |\n            |\n            |\n      =========",
                "        +---+\n        |   |\n        O   |\n        |   |\n            |\n            |\n      =========",
                "        +---+\n        |   |\n        O   |\n       /|   |\n            |\n            |\n      =========",
                "        +---+\n        |   |\n        O   |\n       /|\\  |\n            |\n            |\n      =========",
                "        +---+\n        |   |\n        O   |\n       /|\\  |\n       /    |\n            |\n      =========",
                "        +---+\n        |   |\n        O   |\n       /|\\  |\n       / \\  |\n            |\n      ========="
        };
        System.out.println(hangManArt[wrongTurns]);
    }

    /**
     * Checks whether a character (needle) exists in an array of characters
     * (haystack).
     *
     * @param needle   Character to be looked for.
     * @param haystack Array of characters to search in.
     * @return True if the given character was found in the array, false if not.
     * @author Team Prog1
     */
    private static boolean charExistsInArray(char needle, char[] haystack) {
        for (char c : haystack) {
            if (c == needle) {
                return true;
            }
        }
        return false;
    }

    /**
     * Scans user input until obtaining exactly one letter and returns it converted
     * to uppercase.
     *
     * @return Legal user input character, i.e., a letter, in uppercase.
     * @author Team Prog1
     */
    private static char scanLetterCharToUpperCase() {
        char validCharacter = scanLetterChar();
        String oneCharString = "" + validCharacter;
        return oneCharString.toUpperCase().charAt(0);
    }

    /**
     * Scans user input until obtaining exactly one letter and returns it.
     *
     * @return Legal user input character, i.e., a letter.
     * @author Team Prog1
     */
    private static char scanLetterChar() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Your input: ");
            input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("  => Input must be of length 1, try again.");
            } else if (!Character.isLetter(input.charAt(0))) {
                System.out.println("  => Input must be a letter, try again.");
            }
        } while (input.length() != 1 || !Character.isLetter(input.charAt(0)));

        return input.charAt(0);
    }

    /**
     * Initializes a character array with a given length, fills it with underscores
     * and returns it.
     *
     * @param length Length of the array to be created.
     * @return Character array of the given length, filled with underscores.
     * @author Team Prog1
     */
    private static char[] initialCharArrayOfLength(int length) {
        char[] arr = new char[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '_';
        }
        return arr;
    }

    /**
     * Selects and returns a random uppercase word from a list of programming/uni
     * related words.
     *
     * @return Random uppercase word related to programming / uni.
     * @author Team Prog1
     */
    private static String randomWord() {
        final String[] words = {
                "ALGORITHM",
                "ARRAY",
                "BERLIN",
                "CODING",
                "COMPILER",
                "COMPUTER",
                "DEBUGGING",
                "HTW",
                "INFORMATICS",
                "JAVA",
                "LOOP",
                "METHOD",
                "OPERATOR",
                "PROGRAMMING",
                "SEMESTER",
                "TRESKOWALLEE",
                "VARIABLE"
        };

        return words[(int) (Math.random() * words.length)];
    }
}

// ASCII ART source:
// https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c