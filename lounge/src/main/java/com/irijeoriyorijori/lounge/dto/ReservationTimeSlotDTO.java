package com.irijeoriyorijori.lounge.dto;

import java.util.List;

public class ReservationTimeSlotDTO {

    private String timeSlot;
    private String productId;
    private String availability;

    public ReservationTimeSlotDTO(String timeSlot, String productId, String availability) {
        this.timeSlot = timeSlot;
        this.productId = productId;
        this.availability = availability;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


    @Override
    public String toString() {
        return "ReservationTimeSlotDTO{" +
                "timeSlot='" + timeSlot + '\'' +
                ", productId='" + productId + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
