package Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeTest {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.get(ChronoField.SECOND_OF_DAY));

        Thread.sleep(1000);

        LocalDateTime after = LocalDateTime.now();
        System.out.println(after);
        System.out.println(after.get(ChronoField.SECOND_OF_DAY));

//        System.out.println(LocalDateTime.);
    }
}
