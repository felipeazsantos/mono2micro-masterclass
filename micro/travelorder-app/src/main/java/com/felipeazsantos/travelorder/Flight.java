package com.felipeazsantos.travelorder;

public class Flight {

    private Long id;
    private Long travelOrderId;
    private String fromAirPort;
    private String toAirPort;

    public Flight() {}

    public Flight(Long id, Long travelOrderId, String fromAirPort, String toAirPort) {
        this.id = id;
        this.travelOrderId = travelOrderId;
        this.fromAirPort = fromAirPort;
        this.toAirPort = toAirPort;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTravelOrderId() {
        return travelOrderId;
    }
    public void setTravelOrderId(Long travelOrderId) {
        this.travelOrderId = travelOrderId;
    }
    public String getFromAirPort() {
        return fromAirPort;
    }
    public void setFromAirPort(String fromAirPort) {
        this.fromAirPort = fromAirPort;
    }
    public String getToAirPort() {
        return toAirPort;
    }
    public void setToAirPort(String toAirPort) {
        this.toAirPort = toAirPort;
    }
}
