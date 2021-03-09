package seedu.duke;

import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Person;
import seedu.duke.person.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A list of persons. Does not allow null elements or duplicates.
 */
public class TrackingList {
    private final List<Person> personList = new ArrayList<>();

    /**
     * Constructs a empty Person List
     */
    public TrackingList() {
    }

    /**
     * Constructs a person list with given persons in varargs.
     */
    public TrackingList(Person... persons) {
        final List<Person> initialPersons = Arrays.asList(persons);
        personList.addAll(initialPersons);
    }

    public boolean contains(Person personToCheck) {
        for (Person p : personList) {
            if (p.equals(personToCheck)) {
                return true;
            }
        }
        return false;
    }

    public void add(Person person) {
        personList.add(person);
    }

    public void delete(Person person) {
        personList.remove(person);
    }

    public void delete(int index) {
        personList.remove(index);
    }

    public Person getPerson(int index) {
        return personList.get(index);
    }

    public int getSize() {
        return personList.size();
    }

    /**
     * Finds Person with partial match as id queried
     * @param id id being queried
     * @return Person that partially matches id
     */
    public List<Person> findPerson(Id id) {
        final List<Person> matchingPersons = new ArrayList<>();
        for (Person p : personList) {
            if (p.getId().getId().contains(id.getId())) {
                matchingPersons.add(p);
            }
        }
        return matchingPersons;
    }

    /**
     * Finds Person with partial match as phone queried
     * @param phone Phone being queried
     * @return Person that partially matches phone
     */
    public List<Person> findPerson(Phone phone) {
        final List<Person> matchingPersons = new ArrayList<>();
        for (Person p : personList) {
            if (p.getPhone().getPhone().contains(phone.getPhone())) {
                matchingPersons.add(p);
            }
        }
        return matchingPersons;
    }

    /**
     * Finds Person with partial match as name queried
     * @param name Name being queried
     * @return Person that partially matches name
     */
    public List<Person> findPerson(Name name) {
        final List<Person> matchingPersons = new ArrayList<>();
        for (Person p : personList) {
            if (p.getName().getName().contains(name.getName())) {
                matchingPersons.add(p);
            }
        }
        return matchingPersons;
    }
}
