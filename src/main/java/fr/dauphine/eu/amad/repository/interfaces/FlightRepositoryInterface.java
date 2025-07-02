package fr.dauphine.eu.amad.repository.interfaces;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;


import java.util.List;


public interface FlightRepositoryInterface extends PanacheRepository<Flight> {
    Uni<List<Flight>> searchFlights(SearchCriteria searchCriteria);
    Uni<Flight> getFlightDetails(String flightNumber);
}
