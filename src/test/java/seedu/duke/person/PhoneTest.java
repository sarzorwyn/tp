package seedu.duke.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.person.Phone.isValidPhone;


class PhoneTest {
    static final String CORRECT_PHONE = "91234567";
    static final String WRONG_LEN_PHONE = "9123456";
    static final String NON_DIGITS_PHONE = "9123456a";

    @Test
    void testValidPhone() {
        assertTrue(isValidPhone(CORRECT_PHONE));
        assertFalse(isValidPhone(WRONG_LEN_PHONE));
        assertFalse(isValidPhone(NON_DIGITS_PHONE));
    }

    @Test
    void getPhoneNo() {
    }

    @Test
    void setPhoneNo() {
    }

    @Test
    void isAvailable() {
    }

    @Test
    void setAvailable() {
    }

    @Test
    void testToString() {
    }
}