package seedu.duke.person;

/**
 * Represents the phone number of a person.
 * If a person does not have a phone, isAvailable will be false.
 */
public class Phone {
    public String phoneNo;
    public boolean isAvailable;
    public static final String PHONE_REGEX = "\\d{8}";
    public static final String PHONE_ERROR = "Phone number should consist of only 8 digits";

    /**
     * Constructs a phone object.
     *
     * @param phoneNo Phone number string. Null if Person has no phone.
     */
    public Phone(String phoneNo) {
        assert phoneNo == null || isValidPhone(phoneNo) : PHONE_ERROR;
        this.isAvailable = phoneNo != null;
        this.phoneNo = phoneNo;
    }

    public static boolean isValidPhone(String phoneNo) {
        return phoneNo.matches(PHONE_REGEX);
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        assert isValidPhone(phoneNo) : PHONE_ERROR;
        this.phoneNo = phoneNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
