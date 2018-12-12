package altkom.groupwork.traveloffice.travelofficespring.service;

import altkom.groupwork.traveloffice.travelofficespring.Customer;
import altkom.groupwork.traveloffice.travelofficespring.Trip;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public interface TravelOfficeService {
    Set<Customer> customerSet = new HashSet<>();
    Map<String, Trip> tripMap = new HashMap<>();

    public void addCustomer(Customer customer);

    public int getCustomerCount();

    void addTrip(String keyName, Trip tripName);

    boolean removeTrip(String keyName);

    Customer findCustomerByName(String name);

    boolean removeCustomer(Customer customer);

    Set<Customer> getAllCustomers();

    Map<String,Trip> getAllTrips();

    String showAllCustomers();

    String showAllTrips();

}
