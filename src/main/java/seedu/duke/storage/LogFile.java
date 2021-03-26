package seedu.duke.storage;

import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.Person;
import seedu.duke.person.PersonLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LogFile {
    private static final String DEFAULT_STORAGE_FILEPATH = "LogFile";
    private static final String TXT_FILE_FORMAT = ".txt";
    private static final String DIRECTORY_HOME = System.getProperty("user.dir");

    private final Path path;
    private final File personLog;

    /**
     * Creates LogFile file with default path.
     */
    public LogFile() throws InvalidPathException {
        this(DEFAULT_STORAGE_FILEPATH);
    }

    /**
     * Creates LogFile file with given file path.
     * @param path The path that will be used for storage
     * @throws InvalidPathException If the path specified is invalid
     */
    public LogFile(String path) throws InvalidPathException {
        this.path = Paths.get(DIRECTORY_HOME,path + TXT_FILE_FORMAT);
        this.personLog = new File(this.path.toString());
    }

    public void savePerson(Person person, boolean append) throws StorageOperationException {
        try {
            FileOutputStream fileOut = new FileOutputStream(personLog, append);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(person);

            fileOut.close();
            objectOut.close();
        } catch (IOException e) {
            throw new StorageOperationException("Error writing to file: " + path);
        }
    }

    public void saveAllPersons(ArrayList<Person> persons) throws StorageOperationException {
        for (Person person : persons) {
            this.savePerson(person, false);
        }
    }

    public void loadAllPersons() throws StorageOperationException {
        try {
            FileInputStream fileIn = new FileInputStream(personLog);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object inputObject;
            PersonLog personLog = PersonLog.getInstance();

            while (objectIn.available() != 0) {
                inputObject = objectIn.readObject();
                if (inputObject instanceof Person) {
                    personLog.addPerson((Person) inputObject);
                }
            }
        } catch (IOException e) {
            throw new StorageOperationException("Error loading from file: " + path);
        } catch (ClassNotFoundException e) {
            throw new StorageOperationException("Corrupted file: " + path);
        }
    }

    public void clear() throws StorageOperationException {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(personLog);
            fileOut.close();
        } catch (IOException e) {
            throw new StorageOperationException("Error clearing file: " + path);
        }
    }
}
