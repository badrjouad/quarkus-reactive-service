package fr.dauphine.eu.amad.domain;


import fr.dauphine.eu.amad.domain.enumeration.CustomerStatus;
import fr.dauphine.eu.amad.domain.enumeration.DeviceType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class PricingContext {

    @Enumerated(EnumType.STRING)
    private DeviceType device;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    public PricingContext(DeviceType device, CustomerStatus customerStatus) {
        this.device = device;
        this.customerStatus = customerStatus;
    }

    public PricingContext() {

    }

    public DeviceType getDevice() { return device; }
    public void setDevice(DeviceType device) { this.device = device; }

    public CustomerStatus getCustomerStatus() { return customerStatus; }
    public void setCustomerStatus(CustomerStatus customerStatus) { this.customerStatus = customerStatus; }
}
