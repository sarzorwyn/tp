package seedu.duke.ui;

import seedu.duke.commands.CommandOutput;
import seedu.duke.person.Person;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class TextUi {

    private final PrintStream out;
    private final Scanner in;
    private static final String DIVIDER = "===================================================";

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void printReaction(CommandOutput commandOutput) {
        String command = commandOutput.command;
        switch (command) {
        case "listall":
            printList(commandOutput.persons);
            break;
        case "list":
            printCheckedInList(commandOutput.persons);
            break;
        default:
            printDivider();
            out.println(commandOutput.messageToUser);
            printDivider();
        }
    }

    private void printList(List<Person> persons) {
        assert persons instanceof List : "Only can print list";
        for (Person person : persons) {
            out.println("Name: " + person.getName());
        }
    }

    private void printCheckedInList(List<Person> persons) {
        assert persons instanceof List : "Only prints list";
        for (int i = 0; i < persons.size(); ++i) {
            if (persons.get(i).getCheckedIn()) {
                out.println(i + ". Name: " + persons.get(i).getName());
            }
        }
    }

    public void showWelcomeMessage(String version) {
        printDivider();
        assert version instanceof String : "Version has to be a string";
        out.println("Welcome to Safest Entry Tracker - Version " + version);
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

    public String echoInput(String rawInput) {
        out.println("Command Entered: " + rawInput);
        return rawInput;
    }

    public void notifyErrorToUser(Exception error) {
        assert error instanceof Exception : "error has to be exception type.";
        out.println(error.getMessage());
    }


}
