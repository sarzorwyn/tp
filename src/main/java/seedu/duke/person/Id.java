package seedu.duke.person;

public class Id {
    public final String idString;

    public Id(String idString) {
        // Check if id is valid by using regex first.
        this.idString = idString.trim();
    }

    public String getIdString() {
        return idString;
    }

    @Override
    public String toString() {
        return idString;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof Id) {
            return this.idString.equals(((Id) other).idString);
        }
        return false;
    }
}
