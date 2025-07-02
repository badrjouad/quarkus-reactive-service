package fr.dauphine.eu.amad.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Offer extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    public Flight flight;

    private BigDecimal finalPrice;

    @Embedded
    private PricingContext pricingContext;




    public Offer(Flight flight, BigDecimal finalPrice, PricingContext pricingContext) {
        this.flight = flight;
        this.finalPrice = finalPrice;
        this.pricingContext = pricingContext;
    }

    public Offer() {

    }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    public BigDecimal getFinalPrice() { return finalPrice; }
    public void setFinalPrice(BigDecimal finalPrice) { this.finalPrice = finalPrice; }

    public PricingContext getPricingContext() { return pricingContext; }
    public void setPricingContext(PricingContext pricingContext) { this.pricingContext = pricingContext; }

    public Long getId() {
        return id;
    }
}
