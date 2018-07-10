package com.pana.hotel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Guest extends Person {

    @Id private String documentationNumber;

    private String countryOfPresedence;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Guest{");
        sb.append("documentationNumber='").append(documentationNumber).append('\'');
        sb.append(", countryOfPresedence='").append(countryOfPresedence).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Guest guest = (Guest) o;
        return Objects.equals(documentationNumber, guest.documentationNumber) && Objects.equals(countryOfPresedence, guest.countryOfPresedence);
    }

    @Override
    public int hashCode() {

        return Objects.hash(documentationNumber, countryOfPresedence);
    }

    public String getDocumentationNumber() {

        return documentationNumber;
    }

    public void setDocumentationNumber(String documentationNumber) {
        this.documentationNumber = documentationNumber;
    }

    public String getCountryOfPresedence() {
        return countryOfPresedence;
    }

    public void setCountryOfPresedence(String countryOfPresedence) {
        this.countryOfPresedence = countryOfPresedence;
    }
}
