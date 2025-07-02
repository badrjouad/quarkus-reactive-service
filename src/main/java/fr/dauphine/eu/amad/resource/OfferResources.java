package fr.dauphine.eu.amad.resource;

import fr.dauphine.eu.amad.domain.*;
import fr.dauphine.eu.amad.repository.interfaces.PricingEngineRepository;
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
@Path("/api/offers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class OfferResources {

    @Inject
    PricingEngineRepository pricingEngineRepository;

    @GET
    public List<Offer> getAll()
    {
        return Offer.listAll();
    }

    @POST
    @Path("add")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Offer add(Offer offer) {
        Uni<Flight> existingFlight = Flight.findById(offer.getFlight().getId());
        if (existingFlight == null) {
            throw new WebApplicationException("Flight not found", 404);
        }
        Offer.persist(offer);
        return offer;
    }


    @POST
    @Path("/generate")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Offer generateOffer(GenerateOfferRequest request) {
        return pricingEngineRepository.generateOffer(request.flight, request.context);
    }



}
