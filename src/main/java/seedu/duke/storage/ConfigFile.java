package seedu.duke.storage;

import seedu.duke.exceptions.StorageOperationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {

    public static final String CONFIG_FILE = "settings.properties";

    private final Properties prop;
    private String storageFilePath;

    /** Runs load when initialized. */
    public ConfigFile() {
        prop = new Properties();
        this.load();
    }

    public void load() {
        try {
            File file = new File(CONFIG_FILE);
            FileInputStream inputStream = new FileInputStream(file);

            prop.load(inputStream);
            storageFilePath = prop.getProperty("StorageFilePath");
        } catch (IOException e) {
            // If the file does not exist, return a null Storage file path
            storageFilePath = null;
        }
    }

    private void save() throws StorageOperationException {
        File file = new File(CONFIG_FILE);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(CONFIG_FILE);
            prop.store(fileWriter, "Config file");
        } catch (IOException soe) {
            throw new StorageOperationException("Error writing to file: " + CONFIG_FILE);
        }
    }

    public String getStorageFilePath() {
        return storageFilePath;
    }

    public void setStorageFilePath(String storageFilePath) throws StorageOperationException {
        this.storageFilePath = storageFilePath;
        prop.setProperty("StorageFilePath", storageFilePath);
        this.save();
    }
}
