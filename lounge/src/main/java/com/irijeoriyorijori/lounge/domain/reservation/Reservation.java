package com.irijeoriyorijori.lounge.domain.reservation;

import jakarta.persistence.*;

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
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "created_at")
    private Date createdAt;  //해당 예약을 한 시간

    @Column(name = "updated_at")
    private Date updatedAt;  //예약 수정기능이 있는 시간 (createdAt이랑 처음에 같게 들어간다)

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // 예약 생성 시 createdAt, updatedAt 자동 설정
    @PrePersist
    protected void onCreate() {
        Date currentTime = new Date();  // 현재 시간을 저장
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }

    // 예약 업데이트 시 updatedAt 자동 설정
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();  // 수정 시 현재 시간으로 업데이트
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
