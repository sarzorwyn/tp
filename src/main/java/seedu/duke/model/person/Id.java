package seedu.duke.model.person;

import java.util.Objects;

import static seedu.duke.common.Messages.ID_ERROR;

public class Id {
    public final String idString;

    /*
     * First 3 characters of ID should be digits.
     * The last character should be an uppercase english alphabet.
     */
    public static final String ID_REGEX = "\\d{3}[A-Z]";

    /**
     * Constructs a {@code Id}.
     *
     * @param idString A valid Id.
     */
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

    /**
     * Checks the format of the id string using RegEx.
     *
     * @param idString Id of a Person.
     * @return True if the id format is valid. False otherwise.
     */
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

    /**
     * Used by personLog HashMap in PersonLog class.
     * Hash of id string is used as a key for Persons in PersonLog.
     *
     * @return Hash value for id string.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idString);
    }
}
