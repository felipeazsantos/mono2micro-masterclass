package com.felipeazsantos.travelorder;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("travelorder")
public class TravelOrderResource {

    @RestClient
    @Inject
    FlightService flighService;

    @RestClient
    @Inject
    HotelService hotelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders() {
        return TravelOrder.<TravelOrder>listAll().stream().
            map(order -> TravelOrderDTO.of(
                order, 
                flighService.findByTravelOrderId(order.id), 
                hotelService.findByTravelOrderId(order.id)) 
            ).
            collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    public TravelOrder findById(@QueryParam("id") long id) {
        return TravelOrder.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newTravelOrder(TravelOrderDTO orderDto) {        
        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        Flight flight = new Flight();
        flight.setFromAirPort(orderDto.getFromAirPort());;
        flight.setToAirPort(orderDto.getToAirPort());
        flight.setTravelOrderId(order.id);
        flighService.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.setNights(orderDto.getNights());
        hotel.setTravelOrderId(order.id);
        hotelService.newHotel(hotel);
        
        return order;
    }
}
