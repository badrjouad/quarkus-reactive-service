package fr.dauphine.eu.amad.service.interfaces;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import io.smallrye.mutiny.Uni;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightSearchService {

    Uni<List<Flight>> searchFlights(SearchCriteria searchCriteria);
    Flight getFlightDetails(String flightNumber);

}
