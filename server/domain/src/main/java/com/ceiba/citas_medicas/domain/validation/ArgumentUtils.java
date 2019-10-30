package com.ceiba.citas_medicas.domain.validation;

import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public final class ArgumentUtils {

    private ArgumentUtils() { }

    /**
     * Throws an exception if the arguments is null or whitespace only.
     * @param s argument
     * @param message detail message to be used in the event that a {@code IllegalArgumentException} is thrown
     * @return argument
     * @throws IllegalArgumentException if arguments is null or whitespace only
     */
    public static String requireNonBlank(String s, String message) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(message);
        }
        return s;
    }

    public static void requireDateGreater(LocalDateTime date1, LocalDateTime date2, String message) {
        if (!date2.isAfter(date1)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void requireNotWeekend(LocalDateTime date, String message) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void requireDifferentDay(LocalDateTime date1, LocalDateTime date2, String message) {
        if (date1.toLocalDate().isEqual(date2.toLocalDate())) {
            throw new IllegalArgumentException(message);
        }
    }
}
