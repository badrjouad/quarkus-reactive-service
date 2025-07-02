package fr.dauphine.eu.amad.repository.interfaces;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.Offer;
import fr.dauphine.eu.amad.domain.PricingContext;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.math.BigDecimal;

public interface PricingEngineRepository extends PanacheRepository<Offer> {
    Offer generateOffer(Flight flight, PricingContext context);
}
