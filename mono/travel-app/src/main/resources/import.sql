create sequence  travelorder_sequence start with 1 increment by 1;
insert into TravelOrder(id) values (nextval('travelorder_sequence'));
insert into TravelOrder(id) values (nextval('travelorder_sequence'));
insert into TravelOrder(id) values (nextval('travelorder_sequence'));
insert into TravelOrder(id) values (nextval('travelorder_sequence'));
insert into TravelOrder(id) values (nextval('travelorder_sequence'));

create sequence flight_sequence start with 1 increment by 1;
insert into Flight(id, travelOrderId, fromAirPort, toAirPort) values (nextval('flight_sequence'), 1, 'GRU', 'MCO');
insert into Flight(id, travelOrderId, fromAirPort, toAirPort) values (nextval('flight_sequence'), 1, 'GRU', 'JFK');
insert into Flight(id, travelOrderId, fromAirPort, toAirPort) values (nextval('flight_sequence'), 1, 'GRU', 'ATL');
insert into Flight(id, travelOrderId, fromAirPort, toAirPort) values (nextval('flight_sequence'), 1, 'GRU', 'MEX');

create sequence hotel_sequence start with 1 increment by 1;
insert into Hotel(id, travelOrderId, nights) values (nextval('hotel_sequence'), 1, 10);
insert into Hotel(id, travelOrderId, nights) values (nextval('hotel_sequence'), 2, 4);
insert into Hotel(id, travelOrderId, nights) values (nextval('hotel_sequence'), 3, 6);
insert into Hotel(id, travelOrderId, nights) values (nextval('hotel_sequence'), 4, 5);
insert into Hotel(id, travelOrderId, nights) values (nextval('hotel_sequence'), 5, 2);