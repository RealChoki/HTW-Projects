package htw.berlin.wi.prog2.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInputWrapper {
    private final Scanner scanner;
    private final PrintStream out;

    public UserInputWrapper(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public String ask(String message) {
        out.println(message);
        return scanner.nextLine();
    }
}
