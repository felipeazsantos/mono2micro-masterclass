package com.felipeazsantos.travelorder;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8083/flight")
public interface FlightService {
    @GET
    @Path("findById")
    public Flight findById(@QueryParam("id") long id) ;

    @GET
    @Path("findByTravelOrderId")
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
        requestVolumeThreshold=4,
        failureRatio=0.5,
        delay=5000,
        successThreshold=2
    )
    public Flight findByTravelOrderId(@QueryParam("travelOrderId") long travelOrderId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Flight newFlight(Flight flight);

    default Flight fallback(long travelOrderId) {
        Flight flight = new Flight();
        flight.setFromAirPort("");
        flight.setToAirPort("");
        flight.setTravelOrderId(travelOrderId);
        return flight;
    };
    
}
