package seedu.duke.storage;

import seedu.duke.person.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PersonLog {
    private static final String DEFAULT_STORAGE_FILEPATH = "PersonLog";
    private static final String TXT_FILE_FORMAT = ".txt";
    private static final String DIRECTORY_HOME = System.getProperty("user.dir");

    private final Path path;
    private final File personLog;

    /**
     * Creates PersonLog file with default path.
     */
    public PersonLog() throws InvalidPathException {
        this(DEFAULT_STORAGE_FILEPATH);
    }

    /**
     * Creates PersonLog file with given file path.
     * @param path The path that will be used for storage
     * @throws InvalidPathException If the path specified is invalid
     */
    public PersonLog(String path) throws InvalidPathException {
        this.path = Paths.get(DIRECTORY_HOME,path + TXT_FILE_FORMAT);
        this.personLog = new File(this.path.toString());
    }

    public void savePerson(Person person) throws FileNotFoundException, IOException {
        FileOutputStream fileOut = new FileOutputStream(personLog);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(person);

        fileOut.close();
        objectOut.close();
    }

    public void saveAllPersons(ArrayList<Person> persons) throws IOException {
        for (Person person : persons) {
            this.savePerson(person);
        }
    }

    public ArrayList<Person> loadAllPersons() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(personLog);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        ArrayList<Person> persons = new ArrayList<>();
        Object inputObject;

        while (objectIn.available() != 0) {
            inputObject = objectIn.readObject();
            if (inputObject instanceof Person) {
                persons.add((Person) inputObject);
            }
        }
        return persons;
    }
}
