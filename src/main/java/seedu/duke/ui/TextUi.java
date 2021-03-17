package seedu.duke.ui;

import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CommandOutput;
import seedu.duke.person.Person;
import java.util.logging.Logger;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class TextUi {

    private PrintStream out;
    private Scanner in;
    private static Logger logger = Logger.getLogger(TextUi.class.getSimpleName());

    private static final String DIVIDER = "===================================================";

    //Input errors messages
    private static final String INVALID_COMMAND_ERROR = "Invalid command detected. Try again!";
    private static final String NO_ARGUMENT_ERROR = "No argument passed! Try again!";
    private static final String WRONG_FLAG_ERROR = "Wrong flags used!";

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
        case "list":
            printList(commandOutput.persons);
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
            if (person.getCheckedIn()) {
                out.println("Name: " + person.getName());
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
        // logger.info("Processed user input in textui.");
        return rawInput;
    }

    public String echoInput(String rawInput) {
        out.println("Command Entered: " + rawInput);
        return rawInput;
    }

    public void printInvalidCommandError() {out.println(INVALID_COMMAND_ERROR);}
    public void printNoArgumentError() {out.println(NO_ARGUMENT_ERROR);}
    public void printWrongFlagError() {out.println(WRONG_FLAG_ERROR);}
}
