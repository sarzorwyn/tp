package seedu.duke.model.person;

import static seedu.duke.common.Messages.PHONE_ERROR;

/**
 * Represents the phone number of a person.
 * If a person does not have a phone, isAvailable will be false.
 */
public class Phone {
    private static final long serialVersionUID = 4L;
    public String phoneNo;
    public boolean isAvailable;
    public static final String PHONE_REGEX = "\\d{8}";

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
        if (phoneNo == null) {
            return true;
        }
        return phoneNo.matches(PHONE_REGEX);
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        assert phoneNo == null || isValidPhone(phoneNo) : PHONE_ERROR;
        this.isAvailable = phoneNo != null;
        this.phoneNo = phoneNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return phoneNo;
    }
}
