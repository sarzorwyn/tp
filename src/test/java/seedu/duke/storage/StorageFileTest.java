package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.model.TrackingList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.duke.storage.StorageFile.TXT_FILE_FORMAT;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_STORAGE_TRACKING_LIST;

public class StorageFileTest {
    private static final String TEST_DATA_PATH = "src/test/data/StorageFileTest/";
    private static final String VALID_DATA_FILE = "ValidData";
    private static final String INVALID_DATA_FILE = "InvalidData";
    private static final String NON_EXISTENT_FILE = "NotExistent";
    private static final String NEW_FILE = "NewFile";

    @Test
    public void constructor_invalidFilePath_StorageOperationExceptionThrown() {
        String invalidPath = ":-?;\0";
        assertThrows(StorageOperationException.class, () -> new StorageFile(invalidPath));
    }

    @Test
    public void constructor_defaultConstructor_success() throws Exception {
        try {
            new StorageFile();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void load_invalidFormat_StorageOperationExceptionThrown()
            throws StorageOperationException {
        StorageFile storage = new StorageFile(TEST_DATA_PATH + INVALID_DATA_FILE);
        assertThrows(StorageOperationException.class, storage::load);
    }

    @Test
    public void load_validFormat_success() throws Exception {
        StorageFile storage = new StorageFile(TEST_DATA_PATH + VALID_DATA_FILE);
        TrackingList actualTrackingList = storage.load();

        TrackingList expectedTrackingList = SAMPLE_STORAGE_TRACKING_LIST;
        assertEquals(actualTrackingList.listPerson(), expectedTrackingList.listPerson());
    }

    @Test
    public void load_nonExistentFile_returnsEmptyTrackingList() throws Exception {
        StorageFile storage = new StorageFile(TEST_DATA_PATH + NON_EXISTENT_FILE);
        TrackingList actualTrackingList = storage.load();

        TrackingList expectedTrackingList = new TrackingList();
        assertEquals(actualTrackingList.listPerson(), expectedTrackingList.listPerson());
    }

    @Test
    public void testSave() throws Exception {
        StorageFile storage = new StorageFile(TEST_DATA_PATH + NEW_FILE);
        TrackingList savedTrackingList = SAMPLE_STORAGE_TRACKING_LIST;
        storage.save(savedTrackingList);

        Path savedFilePath = Paths.get(TEST_DATA_PATH + NEW_FILE + TXT_FILE_FORMAT);
        Path validFilePath = Paths.get(TEST_DATA_PATH + VALID_DATA_FILE + TXT_FILE_FORMAT);

        List<String> savedFile = Files.readAllLines(savedFilePath);
        List<String> validFile = Files.readAllLines(validFilePath);
        assertEquals(savedFile, validFile);

        // Clean up
        Files.deleteIfExists(savedFilePath);
    }
}
