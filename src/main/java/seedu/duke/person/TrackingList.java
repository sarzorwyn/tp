package seedu.duke.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A list of persons. Does not allow null elements or duplicates.
 */
public class TrackingList {
    private final List<Person> personList = new ArrayList<>();

    /**
     * Constructs a empty Person List.
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

    /**
     * Checks if a list contains the person in given argument.
     * @param personToCheck Person to check if contained in personList
     * @return True if personList contains Person, False if personList does not contains Person
     */
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

    public List<Person> listPerson() {
        final List<Person> returnedList = new ArrayList<>(personList);
        return returnedList;
    }
    
    /**
     * Finds Person with exact match as id queried.
     * @param id id being queried
     * @return Person that partially matches id
     */
    public Person findExactPerson(Id id) {
        Person matchingPerson = null;
        for (Person p : personList) {
            if (p.getId().equals(id)) {
                matchingPerson = p;
            }
        }
        return matchingPerson;
    }

    /**
     * Finds Person with partial match as phone queried.
     * @param phone Phone being queried
     * @return Person that partially matches phone
     */
    public List<Person> findPerson(Phone phone) {
        final List<Person> matchingPersons = new ArrayList<>();
        for (Person p : personList) {
            if (p.getPhone().getPhoneNo().contains(phone.getPhoneNo())) {
                matchingPersons.add(p);
            }
        }
        return matchingPersons;
    }

    /**
     * Finds Person with partial match as name queried.
     * @param name Name being queried
     * @return Person that partially matches name
     */
    public List<Person> findPerson(Name name) {
        final List<Person> matchingPersons = new ArrayList<>();
        for (Person p : personList) {
            if (p.getName().getNameString().contains(name.getNameString())) {
                matchingPersons.add(p);
            }
        }
        return matchingPersons;
    }
}
