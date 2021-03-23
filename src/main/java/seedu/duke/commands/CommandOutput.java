package seedu.duke.commands;

import seedu.duke.person.Person;

import java.util.List;

/**
 * Represents the output of a command execution.
 */
public class CommandOutput {

    public final String messageToUser;
    public final List<Person> persons;
    public final Person person;
    public final String command;

    public CommandOutput(String messageToUser, String command) {
        this.messageToUser = messageToUser;
        persons = null;
        person = null;
        this.command = command;
    }

    public CommandOutput(List<Person> persons, String command) {
        messageToUser = null;
        this.persons = persons;
        person = null;
        this.command = command;
    }

    public CommandOutput(Person person, String command) {
        this.messageToUser = null;
        persons = null;
        this.person = person;
        this.command = command;
    }

}
