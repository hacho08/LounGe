package com.irijeoriyorijori.lounge.domain.review;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "review_id")
    private String reviewId;

    @Column(name = "user_id")
    private String productItemId;

    @Column(name = "reservation_id")
    private String reservationId;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(String productItemId) {
        this.productItemId = productItemId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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


    // 리뷰 생성 시 createdAt, updatedAt 자동 설정
    @PrePersist
    protected void onCreate() {
        Date currentTime = new Date();  // 현재 시간을 저장
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }

    // 리뷰 업데이트 시 updatedAt 자동 설정
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();  // 수정 시 현재 시간으로 업데이트
    }


    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", productItemId='" + productItemId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
