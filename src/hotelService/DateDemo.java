package hotelService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2022, 7, 7);
        System.out.println(localDate);
        LocalDate teraz = LocalDate.now();
        System.out.println(teraz);
        LocalDate localDate1 = LocalDate.parse("1990-12-26");
        System.out.println(localDate1 + "---");
        long age = localDate1.until(LocalDate.now(), ChronoUnit.YEARS);
        System.out.println(age + "   asdasd");

        System.out.println(localDate.until(teraz, ChronoUnit.DAYS) + " minelo tyle dni");

//        LocalDate parsed = LocalDate.parse("20.01.1992");
//        System.out.println(parsed);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate parsedFormated = LocalDate.parse("20.01.1992", dateTimeFormatter);
        System.out.println(parsedFormated);

    }
}
