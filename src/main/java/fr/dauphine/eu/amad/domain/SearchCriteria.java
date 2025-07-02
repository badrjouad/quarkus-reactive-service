package fr.dauphine.eu.amad.domain;



import fr.dauphine.eu.amad.domain.enumeration.CustomerStatus;
import fr.dauphine.eu.amad.domain.enumeration.DeviceType;

import java.time.LocalDate;
import java.time.LocalTime;

public class SearchCriteria {

    private String origin;
    private String destination;
    private LocalDate departureDate;
    private DeviceType device;
    private CustomerStatus customerStatus;
    private int pastBookings;
    private LocalTime requestTime;

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }

    public DeviceType getDevice() { return device; }
    public void setDevice(DeviceType device) { this.device = device; }

    public CustomerStatus getCustomerStatus() { return customerStatus; }
    public void setCustomerStatus(CustomerStatus customerStatus) { this.customerStatus = customerStatus; }

    public int getPastBookings() { return pastBookings; }
    public void setPastBookings(int pastBookings) { this.pastBookings = pastBookings; }

    public LocalTime getRequestTime() { return requestTime; }
    public void setRequestTime(LocalTime requestTime) { this.requestTime = requestTime; }
}
