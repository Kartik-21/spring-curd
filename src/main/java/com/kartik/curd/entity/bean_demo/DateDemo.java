package com.kartik.curd.entity.bean_demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        LocalDate localDate1 = LocalDate.of(1200, Month.NOVEMBER, 6);

        LocalTime localTime = LocalTime.now();

        LocalTime localTime1 = LocalTime.MIDNIGHT;
        LocalTime localTime2 = LocalTime.NOON;

        LocalTime localTime3 = LocalTime.of(10, 30, 20);


        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime localDateTime1 = LocalDateTime.of(2022, Month.APRIL, 21, 5, 23, 20);


        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);


        System.out.println("DateDemo.main");
        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime3);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);


        LocalDate date = localDateTime.toLocalDate();
        System.out.println("localDateTime -> date");
        System.out.println(date);


        LocalTime time = LocalDateTime.now().toLocalTime();
        System.out.println("localDateTime -> time");
        System.out.println(time);


        DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
        System.out.println("localDateTime -> dayOfWeek");
        System.out.println(dayOfWeek);



        ZonedDateTime zonedDateTime = ZonedDateTime.now(Clock.systemDefaultZone());
        System.out.println(Clock.systemDefaultZone());
        System.out.println(zonedDateTime.toLocalDateTime());

        ZoneId zoneId = Clock.systemUTC().getZone();
        System.out.println(zoneId.toString());

        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();

        ZonedDateTime paris = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("Paris " + paris);
        ZonedDateTime london = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.println("London " + london);

        System.out.println(paris.getHour() - london.getHour());

        System.out.println(LocalDate.now().minusDays(2));
        System.out.println(localDate.isAfter(LocalDate.now().minusDays(-2)));

        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek());

        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getChronology());


        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.plusDays(6);

        Period period = Period.between(date1, date2);
        System.out.println(Period.between(date1, date2).getDays());


//        long duration= Duration.;
//        System.out.println(duration);

        LocalDateTime start1 = LocalDateTime.now();

        List<DayOfWeek> dayOfWeeks = new ArrayList<>();
        for (Month month : Month.values()) {
            DayOfWeek day = LocalDate.now().withYear(2022).with(month).with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
            dayOfWeeks.add(day);
        }
        LocalDateTime end1 = LocalDateTime.now();

        System.out.println(Duration.between(start1, end1).getNano());
        LocalDateTime start2 = LocalDateTime.now();

        Stream.of(Month.values()).map(month -> LocalDate.now().withYear(2022).with(month).with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek()).collect(Collectors.toList());

        LocalDateTime end2 = LocalDateTime.now();
        System.out.println(Duration.between(start2, end2).getNano());

        System.out.println(Duration.between(start1, end2).getNano());


        System.out.println("\n\n\n");

        Stream.of(ZoneId.getAvailableZoneIds()).forEach(System.out::println);
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    }
}
