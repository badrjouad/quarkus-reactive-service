package fr.dauphine.eu.amad.repository.impl;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.Offer;
import fr.dauphine.eu.amad.domain.PricingContext;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import fr.dauphine.eu.amad.domain.enumeration.DeviceType;
import fr.dauphine.eu.amad.repository.interfaces.FlightRepositoryInterface;
import fr.dauphine.eu.amad.repository.interfaces.PricingEngineRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ApplicationScoped
public class PrincingEngineImpl implements PricingEngineRepository {

    @Inject
    FlightRepositoryInterface flightRepositoryInterface;

    @Override
    public Offer generateOffer(Flight flight, PricingContext context) {

        BigDecimal dynamicPrice = calculateDynamicPrice(flight, context);
        Offer offer = new Offer();
        offer.setFlight(flight);
        if (offer.getPricingContext() == null) {
            offer.setPricingContext(new PricingContext());
        }

        offer.getPricingContext().setCustomerStatus(context.getCustomerStatus());
        offer.getPricingContext().setDevice(context.getDevice());

        offer.setFinalPrice(dynamicPrice);
        offer.persist();
        return offer;
    }

    public BigDecimal calculateDynamicPrice(Flight flight, PricingContext context) {
        BigDecimal basePrice = flight.getBasePrice();
        BigDecimal multiplier = BigDecimal.ONE;

        switch (context.getCustomerStatus()) {
            case GOLD -> multiplier = new BigDecimal("0.90"); // 10% de réduction
            case SILVER -> multiplier = new BigDecimal("0.95"); // 5% de réduction
            case PLATINUM -> multiplier = new BigDecimal("0.85"); // 15% de réduction
            case REGULAR -> multiplier = BigDecimal.ONE;
        }


        if (context.getDevice() == DeviceType.MOBILE) {
            multiplier = multiplier.multiply(new BigDecimal("1.02")); // +2%
        }

        return basePrice.multiply(multiplier).setScale(2, RoundingMode.HALF_UP);
    }
}
