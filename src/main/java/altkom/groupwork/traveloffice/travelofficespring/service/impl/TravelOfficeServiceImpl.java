package altkom.groupwork.traveloffice.travelofficespring.service.impl;

import altkom.groupwork.traveloffice.travelofficespring.model.Customer;
import altkom.groupwork.traveloffice.travelofficespring.model.Trip;
import altkom.groupwork.traveloffice.travelofficespring.repository.FakeDatabase;
import altkom.groupwork.traveloffice.travelofficespring.service.TravelOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TravelOfficeServiceImpl implements TravelOfficeService {

    private Set<Customer> customerSet;
    private Map<String, Trip> tripMap;
    private FakeDatabase fakeDatabase;

    @Override
    public String toString() {
        if(customerSet==null) return "";
        StringBuilder info = new StringBuilder("Total clients [" + getCustomerCount() + "]\n\tClient list: ");
        int count = 1;
        for (Customer customer : customerSet) {
            info.append("\n\nClient number [").append(count).append("]\n\n").append(customer.toString());
            ++count;

        }
        return info.toString();
    }

    @Autowired
    public TravelOfficeServiceImpl() {
        this.fakeDatabase = new FakeDatabase();
        this.customerSet = fakeDatabase.getCustomers();
        this.tripMap = fakeDatabase.getTrips();
    }


    @Override
    public void addCustomer(Customer customer) {
        customerSet.add(customer);

    }

    @Override
    public int getCustomerCount() {
        return customerSet.size();
    }

    @Override
    public void addTrip(String keyName, Trip tripName) {
        tripMap.put(keyName, tripName);
    }

    @Override
    public boolean removeTrip(String keyName) {
        if (tripMap.containsKey(keyName)) {
            tripMap.remove(keyName);
            return true;
        } else return false;

    }

    @Override
    public Customer findCustomerByName(String name) {
        for (Customer element : customerSet) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }


    @Override
    public boolean removeCustomer(Customer customer) {
        for (Iterator<Customer> i = customerSet.iterator(); i.hasNext(); ) {
            Customer element = i.next();
            if (element.equals(customer)) {
                i.remove();
                return true;
            }
        }
        return false;
    }


    @Override
    public Set<Customer> getAllCustomers(){
        return customerSet;
    }

    @Override
    public Map<String,Trip> getAllTrips(){
        return tripMap;
    }

    @Override
    public String showAllCustomers() {
        StringBuilder info = new StringBuilder("Total clients \n\n\n\n\n\n\n\n[" + getCustomerCount() + "]\n\tClient list: ");
        int count = 1;
        for (Customer customer : customerSet) {
            info.append("\n\nClient number [").append(count).append("]\n\n").append(customer.getCredentials());
            ++count;

        }
        return info.toString();
    }

    @Override
    public String showAllTrips() {
        StringBuilder info = new StringBuilder("Total trips [" + tripMap.size() + "]\n\tTrip list: ");
        info.append(tripMap.toString());

        return info.toString();

    }
}
