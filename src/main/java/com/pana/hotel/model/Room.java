package com.pana.hotel.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Room {

    @Id private int number;

    @Column private int numberOfBeds;

    @Column private boolean withAView;

    /**
     * some rooms may have names, like "Presidential Suites"
     */
    @Null
    @Column
    private String name;

    /**
     * Plus features addables to a room, Satellite TV, Save, Extra beds... unicorns... anything you can imagine
     */
    @ManyToMany(mappedBy = "room_features", cascade = CascadeType.PERSIST) private List<Feature> features;

    /**
     * Price to rent the room
     */
    @Column private BigDecimal price;

    /**
     * Price to rent the room with plus features
     */
    @Transient private BigDecimal total;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isWithAView() {
        return withAView;
    }

    public void setWithAView(boolean withAView) {
        this.withAView = withAView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Room{");
        sb.append("number=").append(number);
        sb.append(", numberOfBeds=").append(numberOfBeds);
        sb.append(", withAView=").append(withAView);
        sb.append(", name='").append(name).append('\'');
        sb.append(", features=").append(features);
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Room room = (Room) o;
        return number == room.number && numberOfBeds == room.numberOfBeds && withAView == room.withAView && Objects.equals(name, room.name) && Objects.equals(features, room.features) && Objects
                .equals(price, room.price) && Objects.equals(total, room.total);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, numberOfBeds, withAView, name, features, price, total);
    }
}
