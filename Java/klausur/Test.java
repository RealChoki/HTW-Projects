import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test!");
        try {
            System.out.println(readUserInput());
        } catch (InputMismatchException e) {
            System.out.println("Fehler: Bitte geben Sie eine gültige Ganzzahl ein.");
        }
    }

    public static int readUserInput() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine Zahl ein: ");
        int input = scanner.nextInt();
        return input;
    }
}
