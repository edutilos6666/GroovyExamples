package com.edutilos.step1

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoField


class DateTimeExample {
    //Date
    void example1() {
        Date d1 = new Date("10/10/2010")
        Date d2 = new Date("11/11/2011")
        boolean d1Afterd2 = d1.after d2
        boolean d1Befored2 = d1.before d2
        long d1Time = d1.getTime()
        long d2Time = d2.getTime()

        Calendar myCal = new GregorianCalendar()
        myCal.setTime(d1)
        int year = myCal.get(Calendar.YEAR)
        int month = myCal.get(Calendar.MONTH) + 1
        int dayOfMonth = myCal.get(Calendar.DAY_OF_MONTH)
        int dayOfYear = myCal.get(Calendar.DAY_OF_YEAR)
        int dayOfWeek = myCal.get(Calendar.DAY_OF_WEEK)
        int hour = myCal.get(Calendar.HOUR)
        int minute = myCal.get(Calendar.MINUTE)
        int second = myCal.get(Calendar.SECOND)
        int ms = myCal.get(Calendar.MILLISECOND)

        println """year = $year
month = $month 
dayOfMonth = $dayOfMonth
dayOfYear = $dayOfYear
dayOfWeek = $dayOfWeek
hour = $hour 
minute = $minute 
second = $second 
ms = $ms 
"""

    }




    //LocalDate, LocalTime, LocalDateTime
    void example2() {
        LocalDate ld = LocalDate.now()
        LocalDate ld2 = LocalDate.of(2010, 10, 10)
        printLocalDate ld
        println()
        printLocalDate ld2
        println()
        println()

        LocalTime lt = LocalTime.now()
        LocalTime lt2 = LocalTime.of(10, 10, 10)
        printLocalTime lt
        println()
        printLocalTime lt2
        println()
        println()

        LocalDateTime ldt = LocalDateTime.now()
        LocalDateTime ldt2 = LocalDateTime.of(2010, 10, 10, 10, 10, 10)
        printLocalDateTime(ldt)
        println()
        printLocalDateTime(ldt2)
        println()
    }



    private void printLocalDateTime(LocalDateTime ldt) {
        int year = ldt.get(ChronoField.YEAR)
        int monthOfYear = ldt.get(ChronoField.MONTH_OF_YEAR)
        int dayOfMonth = ldt.get(ChronoField.DAY_OF_MONTH)
        int dayOfYear = ldt.get(ChronoField.DAY_OF_YEAR)
        int dayOfWeek = ldt.get(ChronoField.DAY_OF_WEEK)
        int hourOfDay = ldt.get(ChronoField.HOUR_OF_DAY)
        int minuteOfHour = ldt.get(ChronoField.MINUTE_OF_HOUR)
        int secondOfMinute = ldt.get(ChronoField.SECOND_OF_MINUTE)
        int milliOfSecond = ldt.get(ChronoField.MILLI_OF_SECOND)

        println """year = $year
monthOfYear = $monthOfYear
dayOfMonth = $dayOfMonth
dayOfYear = $dayOfYear
dayOfWeek = $dayOfWeek
hourOfDay = $hourOfDay
minuteOfHour = $minuteOfHour
secondOfMinute = $secondOfMinute 
milliOfSecond = $milliOfSecond
"""

    }

    private void printLocalTime(LocalTime lt) {
        int hourOfDay = lt.get(ChronoField.HOUR_OF_DAY)
        int minuteOfHour = lt.get(ChronoField.MINUTE_OF_HOUR)
        int secondOfMinute = lt.get(ChronoField.SECOND_OF_MINUTE)
        int milliOfSecond = lt.get(ChronoField.MILLI_OF_SECOND)

        println """hourOfDay = $hourOfDay
minuteOfHour = $minuteOfHour
secondOfMinute = $secondOfMinute
milliOfSecond = $milliOfSecond
"""

    }

    private void printLocalDate(LocalDate ld) {
        int year = ld.get(ChronoField.YEAR)
        int monthOfYear = ld.get(ChronoField.MONTH_OF_YEAR)
        int dayOfMonth = ld.get(ChronoField.DAY_OF_MONTH)
        int dayOfYear = ld.get(ChronoField.DAY_OF_YEAR)
        int dayOfWeek = ld.get(ChronoField.DAY_OF_WEEK)
        println """year = $year
monthOfYear = $monthOfYear
dayOfMonth = $dayOfMonth
dayOfYear = $dayOfYear
dayOfWeek = $dayOfWeek
"""
    }
}
