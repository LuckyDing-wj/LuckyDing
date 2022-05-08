package com.wj.ding.versioneight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.Date;
import java.util.Locale;

/**
 * @date 2022/5/8 11:12
 * @author: wj
 */
public class TestEightDate {

    private static final Logger logger = LoggerFactory.getLogger(TestEightDate.class);

    public static void main(String[] args) {
//        testLocalDate();
//        testTemporalAdjuster();
//        testLocalTime();
//        testTimeZoneId();
//        testDateTimeFormatter();

    }

    private static void testDateTimeFormatter() {
        ZonedDateTime apollollLaunch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York"));
        String formatted = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(apollollLaunch);
        logger.info(formatted);

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        formatted = formatter.format(apollollLaunch);
        logger.info(formatted);

        formatted = formatter.withLocale(Locale.FRENCH).format(apollollLaunch);
        logger.info(formatted);

        formatted = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm").withLocale(Locale.FRENCH).format(apollollLaunch);
        logger.info(formatted);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.US);
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        logger.info("time format: {}", format);
        logger.info("date {}", new Date());

        LocalDate churchBirthday = LocalDate.parse("1903-06-14");
        logger.info("churchBirthday {}", churchBirthday);

        apollollLaunch = ZonedDateTime.parse("1969-07-16 03:32:00-0400", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx"));
        logger.info("apollollLaunch {}", apollollLaunch);

        for (DayOfWeek w : DayOfWeek.values()) {
            logger.info(w.getDisplayName(TextStyle.SHORT, Locale.US));
        }
    }

    private static void testTimeZoneId() {
        int size = ZoneId.getAvailableZoneIds().size();
        logger.info("available zone id size: {}", size);
        LocalDateTime now = LocalDateTime.now();
        logger.info("now : {}", now);
        // 开始夏令时
        ZonedDateTime skipped = ZonedDateTime.of(LocalDate.of(2013, 3, 31),
                LocalTime.of(2, 30)
                , ZoneId.of("Europe/Berlin"));
        logger.info("skipped: {}", skipped);
        //结束夏令时
        ZonedDateTime ambiguous = ZonedDateTime.of(LocalDate.of(2013, 10, 27),
                LocalTime.of(2, 30)
                , ZoneId.of("Europe/Berlin"));
        logger.info("ambiguous: {}", ambiguous);
        ZonedDateTime ahHourLatter = ambiguous.plusHours(1);
        logger.info("ahHourLatter: {}", ambiguous);

        logger.info("skipped: {}", skipped);
        LocalDateTime plus1 = now.plus(Duration.ofDays(7));
        logger.info("plus1 {}", plus1);
        LocalDateTime plus2 = now.plus(Period.ofDays(7));
        logger.info("plus2 {}", plus2);
    }

    private static void testLocalTime() {
        LocalTime now = LocalTime.now();
        logger.info("now: {}", now);
        LocalTime bedTime = LocalTime.of(10, 0);
        logger.info("bed time: {}", bedTime);
        LocalTime wakeup = bedTime.plusHours(8);
        logger.info("wakeup : {}", wakeup);
    }

    private static void testTemporalAdjuster() {
        // next work day
        TemporalAdjuster temporalAdjuster = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            }
            while (result.getDayOfWeek().getValue() > 6);
            return result;
        };
        LocalDate today = LocalDate.now();
        LocalDate nextWorkDay = today.with(temporalAdjuster);
        logger.info("nextWorkDay: {}", nextWorkDay);
        nextWorkDay = LocalDate.of(2022, 5, 7).with(temporalAdjuster);
        logger.info("nextWorkDay: {}", nextWorkDay);
    }

    private static void testLocalDate() {
        LocalDate today = LocalDate.now();
        logger.info("today: {}", today);

        LocalDate alonzosBirthday = LocalDate.of(1903, 6, 14);
        logger.info("alonzosBirthday: {}", alonzosBirthday);
        alonzosBirthday = LocalDate.of(1903, Month.JUNE, 14);
        logger.info("alonzosBirthday: {}", alonzosBirthday);

        LocalDate programmersDay = LocalDate.of(2018, 1, 1).plusDays(255);
        logger.info("programmersDay: {}", programmersDay);

        LocalDate independenceDay = LocalDate.of(2018, Month.JULY, 4);
        LocalDate christmasDay = LocalDate.of(2018, Month.DECEMBER, 25);
        logger.info("Until Christmas: {}", independenceDay.until(christmasDay));
        logger.info("Until Christmas: {}", independenceDay.until(christmasDay, ChronoUnit.DAYS));

        logger.info("Test plus {}", LocalDate.of(2016, 1, 31).plusMonths(1));
        logger.info("Test minus {}", LocalDate.of(2016, 3, 31).minusMonths(1));

        DayOfWeek dayOfWeek = LocalDate.of(1900, 1, 1).getDayOfWeek();
        logger.info("dayOfWeek {}", dayOfWeek);
        logger.info("dayOfWeek value {}", dayOfWeek.getValue());
    }


}
