package com.pana.hotel.model;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Person.class })
public class PersonTest {

    private Calendar dateOfBirth = new GregorianCalendar();

    @Test
    public void when_date_is_before_the_day_of_birth() {
        mockStatic(Instant.class);

        when(Instant.now()).thenReturn(Instant.parse("2018-02-28T00:00:00.00Z"));
        Person person = new Person();
        dateOfBirth.set(Calendar.YEAR, 1984);
        dateOfBirth.set(Calendar.MONTH, Calendar.JUNE);
        dateOfBirth.set(Calendar.DAY_OF_MONTH, 26);
        verifyStatic(Instant.class);
        person.setDateOfBirth(dateOfBirth.getTime());
        assertEquals(33, person.getAge());
    }
}