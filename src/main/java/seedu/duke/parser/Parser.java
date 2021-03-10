package seedu.duke.parser;

import java.util.Locale;

public class Parser {

    /**
     * Method that splits user input into 2 sections.
     * First section contains desired command
     * Second section contains the description of the task
     *
     * @param text This is the user input. It is a string
     * @return String[] This returns an array, containing 2 fields
     */
    public static String[] splitTextIntoTwoFields(String text) {

        String[] textArray = text.toLowerCase().split(" ", 2);
        return textArray;
    }
    public Command parseCommand(String[] userInput) {
        String command = userInput[0];
        String argument = userInput[1];
        switch (command) {
        case "checkin":
            return parseCheckin(argument);

        case "checkout":
            return parseCheckout(argument);
        case "find":
            return parseFind(argument);
        case"list":
            return parseList(argument);
        case "delete":
            return parseDelete(argument);
        case "exit":
            System.exit(0);
        }

    }

    private void parseDelete(String argument) {
        Arraylist.clear(); //deletes entire list based on our UG.
    }

    private void parseList(String argument) {
        Arraylist.list; //To be edited based on syntax of Arraylist
    }

    private Command parseFind(String argument) {
        String[] findDetails = argument.split("i/",2);
        String id = findDetails[1];
        String name = findDetails[0].substring(1); //starts from index 1 due to inclusion of "/n" flag

        return find(name,id);
    }

    private Command parseCheckout(String argument) {
        String[] checkoutDetails = argument.split("i/",2);
        String id = checkoutDetails[1];
        String name = checkoutDetails[0].substring(1); //starts from index 1 due to inclusion of "/n" flag

        return checkOut(name,id);
    }

    private Command parseCheckin(String argument) {
        String[] checkinDetails = argument.split("i/",2);
        String id = checkinDetails[1];
        String name = checkinDetails[0].substring(1); //starts from index 1 due to inclusion of "/n" flag

        return checkIn(name,id);
    }

}
