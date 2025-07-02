package fr.dauphine.eu.amad.service.impl;


import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.Offer;
import fr.dauphine.eu.amad.domain.PricingContext;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import fr.dauphine.eu.amad.repository.interfaces.PricingEngineRepository;
import fr.dauphine.eu.amad.service.interfaces.PricingEngine;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class PricingEnginerImpl implements PricingEngine {

    @Inject
    PricingEngineRepository pricingEngineRepository;

    @Override
    public Offer generateOffer(Flight flight, PricingContext context) {
        return null;
    }

    @Override
    public BigDecimal calculateDynamicPrice(Flight flight, PricingContext context) {
        return null;
    }
}
