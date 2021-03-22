package seedu.duke.ui;

import seedu.duke.commands.CommandOutput;
import seedu.duke.person.Person;
import java.util.logging.Logger;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class TextUi {

    public static final String PRINT_LISTALL_FORMAT = "|%-15s||%-8s||%-10s||%-8s|";
    public static final String PRINT_LIST_FORMAT =  "|%-16s||%-12s||%-14s|";

    private final PrintStream out;
    private final Scanner in;
    private static final Logger logger = Logger.getLogger(TextUi.class.getSimpleName());

    private static final String DIVIDER = "=".repeat(50);
    private static final String SINGLE_DIVIDER = "-".repeat(50);

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
        case "find":
            printFindList(commandOutput.persons);
            break;
        default:
            printDivider();
            out.println(commandOutput.messageToUser);
            printDivider();
        }
    }

    private void printList(List<Person> persons) {
        assert persons instanceof List : "Only can print list";
        out.println(String.format(PRINT_LISTALL_FORMAT, "Name", "Id", "Phone", "Checked In"));
        printDivider();
        for (int i = 0; i < persons.size(); ++i) {
            String name = persons.get(i).getName().getNameString();
            String Id = persons.get(i).getId().getIdString();
            String Phone = (persons.get(i).getPhone().getPhoneNo() != "null") ? "--" : persons.get(i).getPhone().getPhoneNo();
            String Status = (persons.get(i).getCheckedIn()) ? "Yes" : "No";
            out.println(String.format(PRINT_LISTALL_FORMAT, name, Id, Phone, Status));
            printSingleDivider();
        }
    }

    private void printCheckedInList(List<Person> persons) {
        assert persons instanceof List : "Only prints list";
        out.println(String.format(PRINT_LIST_FORMAT, "Name", "Id", "Phone"));
        printDivider();
        for (int i = 0; i < persons.size(); ++i) {
            String name = persons.get(i).getName().getNameString();
            String Id = persons.get(i).getId().getIdString();
            String Phone = (persons.get(i).getPhone().getPhoneNo() != "null") ? "--" : persons.get(i).getPhone().getPhoneNo();
            out.println(String.format(PRINT_LIST_FORMAT, name, Id, Phone));
            printSingleDivider();
        }
    }

    private void printFindList(List<Person> persons) {
        assert persons instanceof List : "Only prints list";
        out.println("Work in progress");
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

    private void printSingleDivider() {out.println(SINGLE_DIVIDER); }

    public String getUserInput() {
        String rawInput = in.nextLine();
        echoInput(rawInput);
        return rawInput;
    }

    public String echoInput(String rawInput) {
        out.println("Command Entered: " + rawInput);
        return rawInput;
    }

    public String notifyErrorToUser(Exception error) {
        out.println(error.getMessage());
        return error.getMessage();
    }


}
