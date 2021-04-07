package seedu.duke.logic.commands;

import seedu.duke.model.person.Person;

import java.util.List;

/**
 * Represents the output of a command execution.
 */
public class CommandOutput {

    public final String messageToUser;
    public final List<Person> persons;
    public final Person person;
    public final String command;

    /**
     * Creates a CommandOutput that returns a message to the user.
     *
     * @param messageToUser message directly displayed to user
     * @param command command that the user had provided
     */
    public CommandOutput(String messageToUser, String command) {
        this.messageToUser = messageToUser;
        persons = null;
        person = null;
        this.command = command;
    }

    /**
     * Creates a CommandOutput that returns a list of visitors.
     * The list will be formatted properly in the TextUi before displaying it to the user.
     *
     * @param persons required list of visitors
     * @param command command that the user had provided
     */
    public CommandOutput(List<Person> persons, String command) {
        messageToUser = null;
        this.persons = persons;
        person = null;
        this.command = command;
    }

    /**
     * Creates a CommandOutput that returns a visitor.
     * The details of the visitor will be used by the TextUi before displaying it to the user.
     *
     * @param person required visitor
     * @param command command that the user had provided
     */
    public CommandOutput(Person person, String command) {
        this.messageToUser = null;
        persons = null;
        this.person = person;
        this.command = command;
    }

}
