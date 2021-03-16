package seedu.duke.person;

import seedu.duke.exceptions.PersonNotFoundException;

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
        assert personList.contains(person) : "Person not added to list";
    }

    public void delete(Person person) {
        personList.remove(person);
        assert !personList.contains(person) : "Person not removed from list";
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
        assert returnedList.size() == personList.size(): "returnedList does not match listPerson size";
        return returnedList;
    }

    public void clear() {
        personList.clear();
        assert personList.isEmpty(): "List not empty after clear";
    }

    /**
     * Finds Person with exact match as id queried.
     * @param id id being queried
     * @return Person that exactly matches id
     * @throws PersonNotFoundException if no person has queried id
     */
    public Person findExactPerson(Id id) throws PersonNotFoundException {
        Person matchingPerson = null;
        for (Person p : personList) {
            if (p.getId().getIdString().equals(id.getIdString())) {
                matchingPerson = p;
            }
        }
        if (matchingPerson == null) {
            throw new PersonNotFoundException();
        }

        assert matchingPerson.getId().equals(id) : "Result id does not match return id";
        return matchingPerson;
    }

    /**
     * Finds Person with partial match as phone queried.
     * @param phone Phone being queried
     * @return Person that partially matches phone
     * @throws PersonNotFoundException if no person has queried id
     */
    public List<Person> findPerson(Phone phone) throws PersonNotFoundException {
        final List<Person> matchingPersons = new ArrayList<>();
        for (Person p : personList) {
            if (p.getPhone().getPhoneNo().contains(phone.getPhoneNo())) {
                matchingPersons.add(p);
            }
        }

        if (matchingPersons.isEmpty()) {
            throw new PersonNotFoundException();
        }
        return matchingPersons;
    }

    /**
     * Finds Person with partial match as name queried.
     * @param name Name being queried
     * @return Person that partially matches name
     * @throws PersonNotFoundException if no person has queried id
     */
    public List<Person> findPerson(Name name) throws PersonNotFoundException {
        final List<Person> matchingPersons = new ArrayList<>();
        for (Person p : personList) {
            if (p.getName().getNameString().contains(name.getNameString())) {
                matchingPersons.add(p);
            }
        }

        if (matchingPersons.isEmpty()) {
            throw new PersonNotFoundException();
        }
        return matchingPersons;
    }
}
