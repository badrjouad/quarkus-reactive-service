package fr.dauphine.eu.amad.service.impl;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import fr.dauphine.eu.amad.repository.interfaces.FlightRepositoryInterface;
import fr.dauphine.eu.amad.service.interfaces.FlightSearchService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FlightSearchServiceImpl implements FlightSearchService {

    @Inject
    FlightRepositoryInterface flightRepositoryInterface;
    @Override
    public Uni<List<Flight>> searchFlights(SearchCriteria searchCriteria) {

        return flightRepositoryInterface.searchFlights(searchCriteria);
    }

    @Override
    public Flight getFlightDetails(String flightNumber) {
        return null;
    }
}
