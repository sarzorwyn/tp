package seedu.duke.person;

import java.util.Objects;

import static seedu.duke.common.Messages.ID_ERROR;

public class Id {
    private static final long serialVersionUID = 2L;
    public final String idString;
    public static final String ID_REGEX = "\\d{3}[A-Z]";

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

    @Override
    public int hashCode() {
        return Objects.hash(idString);
    }
}
