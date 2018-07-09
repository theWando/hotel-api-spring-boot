package com.pana.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {

    @Id private long id;

    @Column(name = "main_guest") private Guest mainGuest;

    @NotNull
    @ManyToMany(mappedBy = "reservation_guests")
    private List<Guest> companions;

    @Column private Date from;

    @Column private Date to;

}
