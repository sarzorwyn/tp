package seedu.duke.history;

import seedu.duke.datetime.DateTime;
import seedu.duke.exceptions.HistoryStorageException;
import seedu.duke.person.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class HistoryFile {

    public static final String DEFAULT_HISTORY_FILEPATH = "History";
    public static final String FILE_FORMAT = ".txt";
    public static final String DIRECTORY_HOME = System.getProperty("user.dir");

    public Path path;

    public HistoryFile() throws InvalidPathException {
        this(DEFAULT_HISTORY_FILEPATH);
    }

    public HistoryFile(String path) throws InvalidPathException {
        if (path == null) {
            path = DEFAULT_HISTORY_FILEPATH;
        }
        this.path = Paths.get(DIRECTORY_HOME,path + FILE_FORMAT);
    }

    public void saveToHistory(Person person, String movement) throws HistoryStorageException {
        String name = person.getName().getNameString();
        String id = person.getId().getIdString();
        try {
            DateTime datetime = new DateTime();
            File file = new File(DEFAULT_HISTORY_FILEPATH + FILE_FORMAT);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.newLine();
            br.write(name + " " + id + " " + movement + " " + datetime.getDateAndTimeInString());

            br.close();
            fr.close();
        } catch (IOException ioe) {
            throw new HistoryStorageException("Error writing to history file: " + path);
        }
    }

    public void startHistory() throws HistoryStorageException {
        try {
            DateTime datetime = new DateTime();
            File file = new File(DEFAULT_HISTORY_FILEPATH + FILE_FORMAT);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.newLine();
            br.write("===============" + datetime.getDateInString() + "===============");

            br.close();
            fr.close();
        } catch (IOException ioe) {
            throw new HistoryStorageException("Error writing to  history file: " + path);
        }
    }

    public void endHistory() throws HistoryStorageException {
        try {
            DateTime datetime = new DateTime();
            File file = new File(DEFAULT_HISTORY_FILEPATH + FILE_FORMAT);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.newLine();
            br.write("===============" + datetime.getDateInString() + "===============");
            br.close();
            fr.close();
        } catch (IOException ioe) {
            throw new HistoryStorageException("Error writing to  history file: " + path);
        }
    }

}
