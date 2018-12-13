package altkom.groupwork.traveloffice.travelofficespring.service;

import altkom.groupwork.traveloffice.travelofficespring.model.Customer;
import altkom.groupwork.traveloffice.travelofficespring.model.Trip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public interface TravelOfficeService {


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
