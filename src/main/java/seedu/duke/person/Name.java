package seedu.duke.person;

public class Name {
    public final String nameString;

    public Name(String nameString) {
        // Check if valid first using regex
        this.nameString = nameString.trim();
    }

    public String getNameString() {
        return nameString;
    }

    @Override
    public String toString() {
        return nameString;
    }
}
