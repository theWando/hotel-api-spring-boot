package com.pana.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContactInfo {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated private ContactInfoType type;

    @Column private String value;

    private boolean emergencyContact;

    @Override
    public String toString() {
        return "ContactInfo{" + "id=" + id + ", type=" + type + ", value='" + value + '\'' + ", emergencyContact=" + emergencyContact + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ContactInfo that = (ContactInfo) o;
        return id == that.id && emergencyContact == that.emergencyContact && type == that.type && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, value, emergencyContact);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactInfoType getType() {
        return type;
    }

    public void setType(ContactInfoType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(boolean emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
