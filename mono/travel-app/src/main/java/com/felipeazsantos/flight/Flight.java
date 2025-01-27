package com.felipeazsantos.flight;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Flight extends PanacheEntity {
    
    public long travelOrderId;
    public String fromAirPort;
    public String toAirPort;

    public static Flight findByTravelOrderId(Long travelOrderId) {
        return find("travelOrderId", travelOrderId).firstResult();
    };

}
