package seedu.duke.person;

public class Name {
    public final String nameString;
    public static final String NAME_REGEX = "[a-zA-Z][a-zA-Z( )*]{0,99}";
    public static final String NAME_ERROR = "Name should consist of alphabets (or spaces) only. (100 characters limit)";

    public Name(String nameString) {
        assert isValidName(nameString) : NAME_ERROR;
        this.nameString = nameString.trim();
    }

    public static boolean isValidName(String nameString) {
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
