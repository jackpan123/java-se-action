package com.jackpan.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.TemporalAdjusters.*;

public class LocalDateTimeExamples {

    /**
     * Sting to long.
     * @return long
     */
    public long toMilli() {
        final DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        long beginTime = LocalDateTime.parse("2021-10-12 14:54:00", dateTimeFormatter)
                .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        return beginTime;
    }

    public static void main(String[] args) {
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        System.out.println(epochSecond);

        Duration between = Duration.between(LocalDateTime.now(), LocalDateTime.now());
        long seconds = between.getSeconds();
        System.out.println(seconds);

        Period between1 = Period.between(LocalDate.of(2017, 9, 11), LocalDate.of(2017, 9, 21));
        int days = between1.getDays();
        System.out.println(days);

        Duration threeMinutes = Duration.ofMinutes(3);

        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        long seconds1 = threeMinutes.getSeconds();
        System.out.println(seconds1);
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6 ,1);

        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

        String s1 = date1.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date1.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String s3 = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println();

        ZoneId zoneId = ZoneId.of("Europe/Rome");
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(zoneId);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(zoneId);
        Instant instant = Instant.now();
        LocalDateTime.ofInstant(instant, zoneId);

    }
}
