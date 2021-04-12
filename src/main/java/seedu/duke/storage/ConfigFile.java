package seedu.duke.storage;

import seedu.duke.exceptions.StorageOperationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {

    private static final String DEFAULT_FILE = "settings.properties";

    private final Properties prop;
    private String configPath;
    private String storageFilePath;

    public ConfigFile() {
        this(DEFAULT_FILE);
    }

    /** Runs load when initialized. */
    public ConfigFile(String path) {
        prop = new Properties();
        configPath = path;
        this.load();
    }

    /**
     * Loads the config file using the properties class.
     */
    public void load() {
        try {
            File file = new File(configPath);
            FileInputStream inputStream = new FileInputStream(file);

            prop.load(inputStream);
            storageFilePath = prop.getProperty("StorageFilePath");
            inputStream.close();
        } catch (IOException e) {
            // If the file does not exist, return a null Storage file path
            storageFilePath = null;
        }
    }

    /**
     * Saves the config file to the disk using the properties class.
     *
     * @throws StorageOperationException If there is an error writing to config file
     */
    private void save() throws StorageOperationException {
        File file = new File(configPath);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(configPath);
            prop.store(fileWriter, "Config file");
            fileWriter.close();
        } catch (IOException soe) {
            throw new StorageOperationException("Error writing to file: " + configPath);
        }
    }

    public String getStorageFilePath() {
        return storageFilePath;
    }

    /**
     * Sets the storage file path and saves it into the config file.
     *
     * @param storageFilePath The new path which the storage file will be saved at
     * @throws StorageOperationException If there is an error writing to config file
     */
    public void setStorageFilePath(String storageFilePath) throws StorageOperationException {
        this.storageFilePath = storageFilePath;
        prop.setProperty("StorageFilePath", storageFilePath);
        this.save();
    }
}
