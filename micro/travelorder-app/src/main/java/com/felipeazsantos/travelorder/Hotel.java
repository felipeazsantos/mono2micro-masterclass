package com.felipeazsantos.travelorder;

public class Hotel {
    private Long travelOrderId;
    private Integer nights;

    public Hotel() {}

    public Long getTravelOrderId() {
        return travelOrderId;
    }
    public void setTravelOrderId(Long travelOrderId) {
        this.travelOrderId = travelOrderId;
    }
    public Integer getNights() {
        return nights;
    }
    public void setNights(Integer nights) {
        this.nights = nights;
    }

    
}
