package seedu.duke.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateTime {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime DateAndTime = LocalDateTime.now();
    LocalDate DateOnly = LocalDate.now();

    public String getDateAndTimeInString() {
        return dtf.format(DateAndTime);
    }

    public String getDateInString() {
        return df.format(DateOnly);
    }
}
