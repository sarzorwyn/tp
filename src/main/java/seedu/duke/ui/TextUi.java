package seedu.duke.ui;

import seedu.duke.commands.CommandOutput;
import seedu.duke.person.Person;
import java.util.logging.Logger;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class TextUi {

    public static final String PRINT_LISTALL_FORMAT = "|%-3s||%-15s||%-8s||%-10s||%-10s|";
    public static final String PRINT_LIST_FORMAT =  "|%-3s||%-16s||%-12s||%-17s|";

    private final PrintStream out;
    private final Scanner in;
    private static final Logger logger = Logger.getLogger(TextUi.class.getSimpleName());

    private static final String DIVIDER = "=".repeat(57);
    private static final String SINGLE_DIVIDER = "-".repeat(57);

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Does not return any object.
     * Output text to UI based on the type of commandOutput object passed in.
     * listall command and list command prints out a list of persons object.
     * find command prints out a person object.
     *
     * @param commandOutput command object containing data queried by user
     *                      and feedback to user.
     */
    public void printReaction(CommandOutput commandOutput) {
        String command = commandOutput.command;
        switch (command) {
        case "listall":
            assert commandOutput.persons != null : "Expect NoPersonFound Exception,";
            printList(commandOutput.persons);
            break;
        case "list":
            assert commandOutput.persons != null : "Expect NoPersonFound Exception.";
            printCheckedInList(commandOutput.persons);
            break;
        case "find":
            assert commandOutput.person != null : "Expect NoPersonFound Exception.";
            printFindList(commandOutput.person);
            break;
        default:
            printDivider();
            out.println(commandOutput.messageToUser);
            printDivider();
        }
    }

    /**
     * Prints out a list of person objects with respective attributes such as
     * Name, Id, Phone and Checked In status.
     *
     * @param persons person object encapsulated in CommandOutput object.
     */
    private void printList(List<Person> persons) {
        assert persons != null : "Does not print null";
        out.printf((PRINT_LISTALL_FORMAT) + "%n", " ", "Name", "Id", "Phone", "Checked In");
        printDivider();
        printPersonsInListWithStatus(persons);
    }

    /**
     * Prints out a list of person objects with respective attributes such as
     * Name, Id and Phone.
     *
     * @param persons person object encapsulated in CommandOutput object.
     */
    private void printCheckedInList(List<Person> persons) {
        assert persons != null : "Does not print null";
        out.printf((PRINT_LIST_FORMAT) + "%n", " ", "Name", "Id", "Phone");
        printDivider();
        printPersonsInListWithoutStatus(persons);
    }

    private void printPersonsInListWithoutStatus(List<Person> persons) {
        for (int i = 0; i < persons.size(); ++i) {
            Person peronSelected = persons.get(i);
            String name = peronSelected.getName().getNameString();
            String idString = peronSelected.getId().getIdString();
            String phoneString = (peronSelected.getPhone().isAvailable())
                    ? "--" : peronSelected.getPhone().getPhoneNo();
            out.printf((PRINT_LIST_FORMAT) + "%n", i + 1, name, idString, phoneString);
            printSingleDivider();
        }
    }

    private void printFindList(Person person) {
        assert person != null : "Only prints Person";
        out.printf((PRINT_LISTALL_FORMAT) + "%n", " ", "Name", "Id", "Phone", "Checked In");
        printDivider();
        String name = person.getName().getNameString();
        String idString = person.getId().getIdString();
        String phoneString = (person.getPhone().isAvailable())
                ? "--" : person.getPhone().getPhoneNo();
        String statusString = (person.getCheckedIn()) ? "Yes" : "No";
        out.printf((PRINT_LISTALL_FORMAT) + "%n", 1, name, idString, phoneString, statusString);
        printSingleDivider();

    }

    private void printPersonsInListWithStatus(List<Person> persons) {
        for (int i = 0; i < persons.size(); ++i) {
            Person personSelected = persons.get(i);
            String name = personSelected.getName().getNameString();
            String idString = personSelected.getId().getIdString();
            String phoneString = (personSelected.getPhone().isAvailable())
                    ? "--" : personSelected.getPhone().getPhoneNo();
            String statusString = (personSelected.getCheckedIn()) ? "Yes" : "No";
            out.printf((PRINT_LISTALL_FORMAT) + "%n", i + 1, name, idString, phoneString, statusString);
            printSingleDivider();
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

    private void printDivider() {
        out.println(DIVIDER);
    }

    private void printSingleDivider() {
        out.println(SINGLE_DIVIDER);
    }

    /**
     * Takes in user input from Scanner Object.
     *
     * @return String type of user input.
     */
    public String getUserInput() {
        String rawInput = in.nextLine();
        echoInput(rawInput);
        return rawInput;
    }

    /**
     * Allow users to verify input or commands.
     *
     * @param rawInput Input from user.
     * @return Input from user.
     */
    public String echoInput(String rawInput) {
        out.println("Command Entered: " + rawInput);
        return rawInput;
    }

    /**
     * Takes in exception and print error message on UI.
     *
     * @param error Exception thrown from respective command.
     */
    public void notifyErrorToUser(Exception error) {
        out.println(error.getMessage());
    }


}
