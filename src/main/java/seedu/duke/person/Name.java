package seedu.duke.person;

public class Name {
    public final String name;

    public Name(String name) {
        // Check if valid first using regex
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
