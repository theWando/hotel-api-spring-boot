package com.pana.hotel.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false, targetEntity = Guest.class) private Guest mainGuest;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "reservation_companions", joinColumns = { @JoinColumn(name = "reservation_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "guest_documentation_number", referencedColumnName = "documentation_number") })
    private Set<Guest> companions;

    @Column private Date startsOn;

    @Column private Date endsOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Guest getMainGuest() {
        return mainGuest;
    }

    public void setMainGuest(Guest mainGuest) {
        this.mainGuest = mainGuest;
    }

    public Set<Guest> getCompanions() {
        return companions;
    }

    public void setCompanions(Set<Guest> companions) {
        this.companions = companions;
    }

    public Date getStartsOn() {
        return startsOn;
    }

    public void setStartsOn(Date startsOn) {
        this.startsOn = startsOn;
    }

    public Date getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(Date endsOn) {
        this.endsOn = endsOn;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", mainGuest=" + mainGuest + ", companions=" + companions + ", startsOn=" + startsOn + ", endsOn=" + endsOn + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Reservation that = (Reservation) o;
        return Objects.equals(mainGuest, that.mainGuest) && Objects.equals(startsOn, that.startsOn) && Objects.equals(endsOn, that.endsOn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mainGuest, startsOn, endsOn);
    }
}
