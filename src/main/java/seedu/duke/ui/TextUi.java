package seedu.duke.ui;

import seedu.duke.commands.CommandOutput;
import seedu.duke.person.Person;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class TextUi {

    private PrintStream out;
    private Scanner in;

    private static final String DIVIDER = "===================================================";

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void printReaction(CommandOutput commandOutput) {
        switch (commandOutput.command) {
        case "list":
            printList(commandOutput.persons);
            break;
        case "exit":
            showGoodbyeMessage();
            break;
        }
    }

    private void printList(List<Person> persons) {
        for (Person person : persons) {
            if (person.getCheckedIn()) {
                System.out.println("Name: " + person.getName());
            }
        }
    }

    public void showWelcomeMessage(String version) {
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

    private void printDivider() {
        out.println(DIVIDER);
    }

    public String getUserInput() {
        String rawInput = in.nextLine();

        echoInput(rawInput);
        return rawInput;
    }

    private void echoInput(String rawInput) {
        out.println("Command Entered: " + rawInput);
    }

}
