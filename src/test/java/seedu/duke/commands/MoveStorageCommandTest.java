package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageOperationException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class MoveStorageCommandTest {
    @Test
    public void testMoveStorage_invalidPath_StorageOperationException() {
        String invalidPath = ":-?;\0";
        MoveStorageCommand moveStorage = new MoveStorageCommand(invalidPath);
        assertThrows(StorageOperationException.class, () -> moveStorage.execute(SAMPLE_TRACKING_LIST));
    }

    @Test
    public void testMoveStorage_validPath_success() throws StorageOperationException {
        String validPath = "test/validPath";
        MoveStorageCommand moveStorage = new MoveStorageCommand(validPath);
        moveStorage.execute(SAMPLE_TRACKING_LIST);
    }
}
