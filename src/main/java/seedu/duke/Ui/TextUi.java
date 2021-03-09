package seedu.duke.Ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TextUi {

    private static PrintStream out;
    private static Scanner in;

    private static final String DIVIDER = "===================================================";

    public TextUi() { this(System.in, System.out);}
    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public static void showWelcomeMessage(String version) {
        printDivider();
        out.println("Welcome to Safest Entry Tracker - Version" + version + "1");
        // for next patch update - Storage class - dataStorageSuccessful()
        out.println("Data successfully loaded from storage file path.");
        printDivider();
    }

    public void showGoodbyeMessage() {
        printDivider();
        out.println("Exiting Safest Entry Tracker...");
        printDivider();
    }

    private static void printDivider() {
        out.println(DIVIDER);
    }

    public static String getUserInput() {
        String rawInput = in.nextLine();

        echoInput(rawInput);
        return rawInput;
    }

    private static void echoInput(String rawInput) {
        out.println("Command Entered: " + rawInput);
    }

}
