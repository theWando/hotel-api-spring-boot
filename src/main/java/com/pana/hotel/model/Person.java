package com.pana.hotel.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.Date;

@Embeddable
public class Person {

    @NotNull
    @Column
    private String name;

    @Column private String surname;

    @Column private String lastname;

    @Column private Date dateOfBirth;

    @Transient private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull Date dateOfBirth) {
        Instant age = Instant.now().minusMillis(dateOfBirth.getTime());
        this.age = age.get(ChronoField.YEAR);
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
