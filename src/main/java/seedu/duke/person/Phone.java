package seedu.duke.person;

/**
 * Represents the phone number of a person.
 * If a person does not have a phone, isAvailable will be false.
 */
public class Phone {
    public String phone;
    public boolean isAvailable;

    public Phone(String phone) {
        // Validate phone using regex first.
        this.phone = phone;
        this.isAvailable = true;
    }

    /**
     * Constructor if phone is not available.
     */
    public Phone() {
        this.phone = null;
        this.isAvailable = false;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        // Validate phone using regex first.
        this.phone = phone;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
