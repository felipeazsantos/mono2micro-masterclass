package com.felipeazsantos.travelorder;

import com.felipeazsantos.flight.Flight;
import com.felipeazsantos.hotel.Hotel;

public class TravelOrderDTO {

    private String fromAirPort;
    private String toAirPort;
    private int nights;

    public TravelOrderDTO() {
        
    }

    private TravelOrderDTO(String fromAirPort, String toAirPort, int nights) {
        this.fromAirPort = fromAirPort;
        this.toAirPort = toAirPort;
        this.nights = nights;
    }

    public static TravelOrderDTO of(TravelOrder order, Flight flight, Hotel hotel) {
        if (flight == null) {
            flight = new Flight();
        }

        if (hotel == null) {
            hotel = new Hotel();
        }
        
        return new TravelOrderDTO(flight.fromAirPort, flight.toAirPort, hotel.nights);
    }

    public static TravelOrderDTO of(String fromAirPort, String  toAirPort,int nights) {
        return new TravelOrderDTO(fromAirPort, toAirPort, nights);
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

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }
}
