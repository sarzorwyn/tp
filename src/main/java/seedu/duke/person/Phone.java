package seedu.duke.person;

/**
 * Represents the phone number of a person.
 * If a person does not have a phone, isAvailable will be false.
 */
public class Phone {
    public String phoneNo;
    public boolean isAvailable;

    public Phone(String phoneNo) {
        // Validate phone using regex first.
        this.phoneNo = phoneNo;
        this.isAvailable = true;
    }

    /**
     * Constructor if phone is not available.
     */
    public Phone() {
        this.phoneNo = null;
        this.isAvailable = false;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        // Validate phone using regex first.
        this.phoneNo = phoneNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
