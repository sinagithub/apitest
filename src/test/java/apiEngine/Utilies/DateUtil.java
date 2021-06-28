package apiEngine.Utilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

public class DateUtil {

    public static String generateDateNow(){
        return java.time.Clock.systemUTC().instant().atZone(ZoneId.systemDefault()).toLocalDateTime().toString() +"Z";
    }

    public static String getTimeAfterHour(int hour) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(hour).truncatedTo(ChronoUnit.HOURS);
        return end.toString() + ":00.000Z";
    }

    public static String getNextDay(int day) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(day).truncatedTo(ChronoUnit.DAYS);
        return end.toString() + ":00.000Z";
    }
}

