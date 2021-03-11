package seedu.duke.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UiTest {

    private TextUi ui;

    @Test
    public void testEchoEqual() {
        this.ui = new TextUi();
        String input = "checkin n/John i/123a";
        assertTrue(input.equals(ui.echoInput(input)));
    }
}
