package com.irijeoriyorijori.lounge.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "reservation")

public class Reservation {


    @Id
    @Column(name = "reservation_id")
    private String reservationId;

    @Column(name = "product_item_id")
    private String productItemId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(String productItemId) {
        this.productItemId = productItemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public java.lang.String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", productItemId='" + productItemId + '\'' +
                ", userId='" + userId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime=" + endTime +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
