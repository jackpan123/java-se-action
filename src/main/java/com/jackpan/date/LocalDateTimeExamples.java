package com.jackpan.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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
}
