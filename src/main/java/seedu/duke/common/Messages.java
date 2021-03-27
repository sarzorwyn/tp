package seedu.duke.common;

public class Messages {

    private static final String USER_GUIDE_LINK = "https://ay2021s2-cs2113t-t09-1.github.io/tp/UserGuide.html";

    public static final String PERSON_NOT_FOUND = "Person not found!";
    public static final String INVALID_COMMAND = "Invalid command detected! Try again!";
    public static final String NO_ARGUMENT = "No argument passed! Try again!";
    public static final String WRONG_FLAG = "Wrong flags used!";
    public static final String CHECKIN_HELP = "Check-in visitor: checkin n/NAME i/LAST_4_CHARS_OF_ID [p/PHONE_NUMBER]";
    public static final String LIST_ALL_HELP = "List all visitors: listall";
    public static final String LIST_CHECKED_IN_HELP = "List checked-in visitors only: list";
    public static final String FIND_BY_ID_HELP = "Find visitor by ID: find i/LAST_4_CHARS_OF_ID";
    public static final String CHECKOUT_HELP = "Checkout visitor: checkout [n/NAME] i/LAST_4_CHARS_OF_ID";
    public static final String CLEAR_HELP = "Clear all visitor entries: clear";
    public static final String EDIT_CAPACITY_HELP = "Edit venue capacity: editmax NEW_CAPACITY";
    public static final String EXIT_HELP = "Exit Control Your Crowd: exit";
    public static final String USER_GUIDE_LINK_HELP = "Refer to the user guide: " + USER_GUIDE_LINK;

}
