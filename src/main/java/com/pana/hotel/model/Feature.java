package com.pana.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Feature {

    @Id private int id;

    @Column private String name;

    @Column private BigDecimal price;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Feature{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Feature feature = (Feature) o;
        return id == feature.id && Objects.equals(name, feature.name) && Objects.equals(price, feature.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
