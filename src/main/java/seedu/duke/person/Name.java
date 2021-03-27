package seedu.duke.person;

import java.io.Serializable;

import static seedu.duke.common.Messages.NAME_ERROR;

public class Name implements Serializable {
    private static final long serialVersionUID = 3L;
    public final String nameString;
    public static final String NAME_REGEX = "[a-zA-Z][a-zA-Z( )*]{0,29}";

    public Name(String nameString) {
        assert isValidName(nameString) : NAME_ERROR;
        this.nameString = nameString.trim();
    }

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
