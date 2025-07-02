package fr.dauphine.eu.service;

import fr.dauphine.eu.amad.domain.Flight;
import fr.dauphine.eu.amad.domain.Offer;
import fr.dauphine.eu.amad.domain.SearchCriteria;
import fr.dauphine.eu.amad.domain.enumeration.CustomerStatus;
import fr.dauphine.eu.amad.domain.enumeration.DeviceType;
import fr.dauphine.eu.amad.service.interfaces.FlightSearchService;
import fr.dauphine.eu.amad.service.interfaces.PricingEngine;
import io.cucumber.java.en.*;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/*
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    @Inject
    FlightSearchService flightService;

    @Inject
    PricingEngine pricingEngine;

    private final SearchCriteria criteria = new SearchCriteria();
    private List<Flight> flights;
    private List<Offer> offers;

    @Given("la ville de départ est {string}")
    public void setDeparture(String from) {
        criteria.setOrigin(from);
    }

    @Given("la ville d'arrivée est {string}")
    public void setArrival(String to) {
        criteria.setDestination(to);
    }

    @Given("la date de départ est {string}")
    public void setDate(String date) {
        criteria.setDepartureDate(LocalDate.parse(date));
    }

    @Given("l'utilisateur utilise un appareil {string}")
    public void setDevice(String device) {
        criteria.setDevice(DeviceType.valueOf(device.toUpperCase()));
    }

    @Given("le client a le statut {string}")
    public void setStatus(String status) {
        criteria.setCustomerStatus(CustomerStatus.valueOf(status.toUpperCase()));
    }

    @Given("la recherche est faite à {string}")
    public void setHeure(String heureStr) {
        criteria.setRequestTime(LocalTime.parse(heureStr));
    }

    @Given("un utilisateur ayant un historique de {int} réservations")
    public void setPastBookings(int count) {
        criteria.setPastBookings(count);
    }

    @When("l'utilisateur effectue une recherche de vols")
    public void rechercherVols() {
        flights = flightService.searchAvailableFlights(criteria);
        offers = pricingEngine.applyPricing(flights, criteria);
    }

    @Then("une liste de vols disponibles est retournée")
    public void verifierResultats() {
        assertNotNull(offers);
        assertFalse(offers.isEmpty());
    }

    @Then("chaque vol contient un prix de base")
    public void verifierPrixBase() {
        for (Offer o : offers) {
            assertNotNull(o.getFlight().getBasePrice());
        }
    }

    @Then("le prix retourné est ajusté selon le device")
    public void verifierPrixDevice() {
        for (Offer o : offers) {
            assertEquals(criteria.getDevice(), o.getPricingContext().getDevice());
        }
    }

    @Then("le prix est ajusté selon le statut du client")
    public void verifierPrixStatut() {
        for (Offer o : offers) {
            assertEquals(criteria.getCustomerStatus(), o.getPricingContext().getCustomerStatus());
        }
    }

    @Then("le prix est inférieur à celui de l’après-midi")
    public void verifierPrixMatin() {
        for (Offer o : offers) {
            assertTrue(o.getFinalPrice().compareTo(BigDecimal.valueOf(200)) < 0);
        }
    }

    @Then("il voit des offres priorisées avec des prix réduits")
    public void verifierPrixHistorique() {
        for (Offer o : offers) {
            assertTrue(o.getFinalPrice().compareTo(BigDecimal.valueOf(150)) < 0);
        }
    }
}
*/