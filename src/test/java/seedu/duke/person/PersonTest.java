package seedu.duke.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    @Test
    void testEquals() {
        Person p1 = constructPerson("123A", "John", "12345678");
        Person p2 = constructPerson("123A", "John", null);
        Person p3 = constructPerson("456B", "John", "12345678");

        assertTrue(p1.equals(p1));
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals("test string"));
    }

    Person constructPerson(String idString, String nameString, String phoneNo) {
        Id personId = new Id(idString);
        Name personName = new Name(nameString);
        Phone personPhone;
        if (phoneNo == null) {
            personPhone = new Phone();
        } else {
            personPhone = new Phone(phoneNo);
        }
        Person person = new Person(personId, personName, personPhone);
        return person;
    }
}
