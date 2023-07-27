package com.chuwa.codingassignment1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long customerId;

    private double value;

    private double points;

    public Order(){}

    public Order(long id, long customerId, double value, double points, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.customerId = customerId;
        this.value = value;
        this.points = points;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
