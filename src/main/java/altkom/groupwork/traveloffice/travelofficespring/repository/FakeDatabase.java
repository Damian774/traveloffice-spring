package altkom.groupwork.traveloffice.travelofficespring.repository;

import altkom.groupwork.traveloffice.travelofficespring.model.Customer;
import altkom.groupwork.traveloffice.travelofficespring.model.Trip;
import altkom.groupwork.traveloffice.travelofficespring.utils.FakeDatabaseCreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FakeDatabase {
    Set<Customer> customers;
    Map<String, Trip> trips;
    FakeDatabaseCreator fakeDatabaseCreator;

    public FakeDatabase() {
        fakeDatabaseCreator= new FakeDatabaseCreator();
        this.customers = fakeDatabaseCreator.getCustomers();
        this.trips = fakeDatabaseCreator.getTrips();
    }

    public Set<Customer> getCustomers(){
        return customers;
    }

    public Map<String,Trip> getTrips(){
        return trips;
    }

}