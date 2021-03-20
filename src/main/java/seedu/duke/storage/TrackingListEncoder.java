package seedu.duke.storage;

import seedu.duke.person.Person;
import seedu.duke.person.TrackingList;

import java.util.ArrayList;
import java.util.List;

import static seedu.duke.storage.StorageFile.CHECKED_IN_ENCODED_MARKER;
import static seedu.duke.storage.StorageFile.ID_DELIMITER;
import static seedu.duke.storage.StorageFile.PHONE_ENCODED_MARKER;

/**
 * Encodes the {@code TrackingList} object for storage
 */
public class TrackingListEncoder {

    /**
     * Encodes all Person in given trackingList to a list of encoded string for storage
     * @param trackingList List of Persons to be encoded
     * @return Encoded list of Persons
     */
    public static List<String> encodeTrackingList(TrackingList trackingList) {
        final List<String> encodedPersons = new ArrayList<>();
        trackingList.listPerson().forEach(person -> encodedPersons.add(encodePersonToString(person)));
        return encodedPersons;
    }

    /**
     * Encodes Person into a storage string representation
     */
    private static String encodePersonToString(Person person) {

        String encodedPerson = person.getName() +
                ID_DELIMITER +
                person.getId() +
                PHONE_ENCODED_MARKER +
                person.getPhone() +
                CHECKED_IN_ENCODED_MARKER +
                (person.getCheckedIn() ? 1 : 0);
        return encodedPerson;
    }
}
