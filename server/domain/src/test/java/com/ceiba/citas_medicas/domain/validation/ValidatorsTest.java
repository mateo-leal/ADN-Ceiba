package com.ceiba.citas_medicas.domain.validation;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    @Test
    void requireNotWeekend_when_day_is_not_weekend() {
        // arrange
        var notWeekendDay = LocalDateTime.of(2019, Month.OCTOBER, 25, 12, 0);

        // act - assert
        assertDoesNotThrow(() -> Validators.requireNotWeekend(notWeekendDay, ""));
    }

    @Test
    void requireNotWeekend_when_day_is_saturday() {
        // arrange
        var saturday = LocalDateTime.of(2019, Month.OCTOBER, 26, 12, 0);

        // act - assert
        assertThrows(IllegalArgumentException.class, () -> Validators.requireNotWeekend(saturday, ""));
    }

    @Test
    void requireNotWeekend_when_day_is_sunday() {
        // arrange
        var sunday = LocalDateTime.of(2019, Month.OCTOBER, 27, 12, 0);

        // act - assert
        assertThrows(IllegalArgumentException.class, () -> Validators.requireNotWeekend(sunday, ""));
    }
}