package seedu.duke.person;

public class Id {
    public final String id;

    public Id(String id) {
        // Check if id is valid by using regex first.
        this.id = id.trim();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof Id) {
            return this.id.equals(((Id) other).id);
        }
        return false;
    }
}
