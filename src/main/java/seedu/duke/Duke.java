package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.commands.CommandOutput;
import seedu.duke.commands.ExitCommand;
import seedu.duke.parser.Parser;
import seedu.duke.person.TrackingList;
import seedu.duke.ui.TextUi;

import java.util.Scanner;

public class Duke {
    private static final String VERSION_NO = "v1.0";

    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void main(String[] args) {
        TextUi ui = new TextUi();
        Parser parser = new Parser();
        TrackingList trackingList = new TrackingList();
        Command command;
        String userInput;
        ui.showWelcomeMessage(VERSION_NO);
        do {
            userInput = ui.getUserInput();
            command = parser.parseCommand(userInput);
            CommandOutput commandOutput = command.execute(trackingList);
            ui.printReaction(commandOutput);

        } while (!(command instanceof ExitCommand));
    }
}
