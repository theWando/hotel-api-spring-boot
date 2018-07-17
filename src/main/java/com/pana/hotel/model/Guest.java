package com.pana.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Guest extends Person {

    @Id
    @Column(name = "documentation_number")
    private String documentationNumber;

    @Column(name = "country") private String country;

    @OneToMany(mappedBy = "mainGuest", orphanRemoval = true) private Set<Reservation> mainReservations;

    @ManyToMany(mappedBy = "companions") private Set<Reservation> reservations;

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reservation> getMainReservations() {
        return mainReservations;
    }

    public void setMainReservations(Set<Reservation> mainReservations) {
        this.mainReservations = mainReservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Guest guest = (Guest) o;
        return Objects.equals(documentationNumber, guest.documentationNumber) && Objects.equals(country, guest.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(documentationNumber, country);
    }

    @Override
    public String toString() {
        return "Guest{" + "documentationNumber='" + documentationNumber + '\'' + ", country='" + country + '\'' + ", mainReservations=" + mainReservations + ", reservations=" + reservations + "} "
                + super.toString();
    }

    public String getDocumentationNumber() {

        return documentationNumber;
    }

    public void setDocumentationNumber(String documentationNumber) {
        this.documentationNumber = documentationNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
