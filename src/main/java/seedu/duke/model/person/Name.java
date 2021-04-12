package seedu.duke.model.person;

import static seedu.duke.common.Messages.NAME_ERROR;

public class Name {
    public final String nameString;

    /*
     * The name should start with an alphabet character.
     * The rest of the 29 characters can be empty spaces or alphabets.
     */
    public static final String NAME_REGEX = "[a-zA-Z][a-zA-Z( )*]{0,29}";

    /**
     * Constructs a {@code Name}.
     *
     * @param nameString A valid name.
     */
    public Name(String nameString) {
        assert isValidName(nameString) : NAME_ERROR;
        this.nameString = nameString.trim();
    }

    /**
     * Checks the format of the name string using RegEx.
     *
     * @param nameString Name of a Person.
     * @return True if phone number format is valid. False otherwise.
     */
    public static boolean isValidName(String nameString) {
        if (nameString == null) {
            return true;
        }
        return nameString.matches(NAME_REGEX);
    }

    public String getNameString() {
        return nameString;
    }

    @Override
    public String toString() {
        return nameString;
    }
}
