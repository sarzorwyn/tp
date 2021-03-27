package seedu.duke.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateTime {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime dateAndTime = LocalDateTime.now();
    LocalDate dateOnly = LocalDate.now();

    public String getDateAndTimeInString() {
        return dtf.format(dateAndTime);
    }

    public String getDateInString() {
        return df.format(dateOnly);
    }
}
