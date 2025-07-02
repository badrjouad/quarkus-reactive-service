package fr.dauphine.eu.amad.service.interfaces;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.Offer;
import fr.dauphine.eu.amad.domain.PricingContext;
import fr.dauphine.eu.amad.domain.SearchCriteria;

import java.math.BigDecimal;
import java.util.List;

public interface PricingEngine {

    Offer generateOffer(Flight flight, PricingContext context);
    BigDecimal calculateDynamicPrice(Flight flight, PricingContext context);

}
