package com.chuwa.codingassignment1.payload;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
public class OrderDto {
    private long id;

    @NotEmpty(message = "customer id should not be null or empty")
    private long customerId;

    @NotEmpty(message = "Value should not be null or empty")
    private Double value;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    private Double points;

    public OrderDto(long customerId, Double value, LocalDateTime createDateTime, Double points) {
        this.customerId = customerId;
        this.value = value;
        this.createDateTime = createDateTime;
        this.points = points;
    }

    public OrderDto(long id, long customerId, Double value, LocalDateTime createDateTime, Double points) {
        this(customerId, value, createDateTime, points);
        this.id = id;
    }

    public OrderDto(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
