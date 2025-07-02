package fr.dauphine.eu.amad.repository.impl;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import fr.dauphine.eu.amad.repository.interfaces.FlightRepositoryInterface;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class FlightRepositoryImpl implements FlightRepositoryInterface {
    @Override
    public Uni<List<Flight>> searchFlights(SearchCriteria searchCriteria) {
        return Flight.find("origin = :origin and destination = :destination and departureDate = :departureDate",
                Parameters.with("origin", searchCriteria.getOrigin())
                        .and("destination", searchCriteria.getDestination())
                        .and("departureDate", searchCriteria.getDepartureDate())).list();
    }
    @Override
    public Uni<Flight> getFlightDetails(String flightNumber) {
        return Flight.find("flightNumber=:flightNumber",Parameters.with("flightNumber",flightNumber)).firstResult();
    }
}
