package seedu.duke.commands;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageOperationException;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.commands.MoveStorageCommand.TXT_FILE_FORMAT;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class MoveStorageCommandTest {

    public static final String NEW_PATH = "test/newPath";

    @Test
    public void testMoveStorage_invalidPath_StorageOperationException() {
        String invalidPath = ":-?;\0";
        MoveStorageCommand moveStorage = new MoveStorageCommand(invalidPath);
        assertThrows(StorageOperationException.class, () -> moveStorage.execute(SAMPLE_TRACKING_LIST));
    }

    @Test
    public void testMoveStorage_validPath_success() throws StorageOperationException {
        MoveStorageCommand moveStorage = new MoveStorageCommand(NEW_PATH);
        moveStorage.execute(SAMPLE_TRACKING_LIST);
    }

    @AfterAll
    public static void cleanup() throws Exception {
        Files.delete(Paths.get(NEW_PATH + TXT_FILE_FORMAT));
    }
}
