package seedu.duke.commands;

import java.util.ArrayList;

/**
 * Represents the output of a command execution.
 */
public class CommandOutput {

    public final String messageToUser;
    private final ArrayList<Person> persons;

    public CommandOutput(String messageToUser) {
        this.messageToUser = messageToUser;
        persons = null;
    }

    public CommandOutput(ArrayList<Person> persons) {
        messageToUser = null;
        this.persons = persons;
    }

}
