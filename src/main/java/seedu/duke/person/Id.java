package seedu.duke.person;

import java.io.Serializable;

public class Id implements Serializable {
    private static final long serialVersionUID = 2L;
    public final String idString;
    public static final String ID_REGEX = "\\d{3}[A-Z]";
    public static final String ID_ERROR = "ID should be 3 digits followed by a uppercase letter";

    public Id(String idString) {
        assert isValidId(idString) : ID_ERROR;
        this.idString = idString.trim();
    }

    public String getIdString() {
        return idString;
    }

    @Override
    public String toString() {
        return idString;
    }

    public static boolean isValidId(String idString) {
        return idString.matches(ID_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof Id) {
            return idString.equals(((Id) other).getIdString());
        }
        return false;
    }
}
