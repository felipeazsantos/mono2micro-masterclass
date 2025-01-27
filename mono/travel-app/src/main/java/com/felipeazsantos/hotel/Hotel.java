package com.felipeazsantos.hotel;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Hotel extends PanacheEntity {
    
    public long travelOrderId;
    public int nights;

}
