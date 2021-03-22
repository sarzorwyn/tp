package seedu.duke.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.person.Phone.isValidPhone;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.JOHN_DIFF_ID;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;


class PhoneTest {
    static final String CORRECT_PHONE = "91234567";
    static final String WRONG_LEN_PHONE = "9123456";
    static final String NON_DIGITS_PHONE = "9123456a";
    static final Phone JOHN_PHONE = JOHN.getPhone();
    static final Phone JOHN_DIFF_ID_PHONE = JOHN_DIFF_ID.getPhone();
    static final Phone NO_PHONE_JOHN_PHONE = JOHN_NO_PHONE.getPhone();

    @Test
    void testValidPhone() {
        assertTrue(isValidPhone(CORRECT_PHONE));
        assertFalse(isValidPhone(WRONG_LEN_PHONE));
        assertFalse(isValidPhone(NON_DIGITS_PHONE));
    }

    @Test
    void getPhoneNo() {
        assertEquals(JOHN_PHONE.getPhoneNo(), JOHN_DIFF_ID_PHONE.getPhoneNo());
        assertNotEquals(JOHN_PHONE.getPhoneNo(), NO_PHONE_JOHN_PHONE.getPhoneNo());
    }

    @Test
    void setPhoneNo() {
        NO_PHONE_JOHN_PHONE.setPhoneNo(CORRECT_PHONE);
        assertEquals(NO_PHONE_JOHN_PHONE.getPhoneNo(), CORRECT_PHONE);

        NO_PHONE_JOHN_PHONE.setPhoneNo(null);
        assertNull(NO_PHONE_JOHN_PHONE.getPhoneNo());
    }

    @Test
    void isAvailable() {
        assertFalse(NO_PHONE_JOHN_PHONE.isAvailable());
        assertTrue(JOHN_PHONE.isAvailable());
    }

    @Test
    void testToString() {
        assertEquals(JOHN_PHONE.getPhoneNo(), JOHN_PHONE.toString());
    }
}
