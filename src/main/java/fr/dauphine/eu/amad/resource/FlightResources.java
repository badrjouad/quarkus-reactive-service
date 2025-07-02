package fr.dauphine.eu.amad.resource;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import fr.dauphine.eu.amad.repository.interfaces.FlightRepositoryInterface;
import fr.dauphine.eu.amad.service.interfaces.FlightSearchService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@ApplicationScoped
@Path("/api/flight")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class FlightResources {

    @Inject
    FlightSearchService flightSearchService;

    @Inject
    FlightRepositoryInterface flightRepositoryInterface;

    @GET
    public Uni<List<Flight>> getAll()
    {
        return Flight.listAll();
    }

    @POST
    @Path("/searchFlight")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Flight>> getFlights(SearchCriteria searchCriteria)
    {
        return flightSearchService.searchFlights(searchCriteria) ;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Flight> add(Flight flight) {
         return flightRepositoryInterface.persist(flight);

    }
}
