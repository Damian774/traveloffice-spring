package altkom.groupwork.traveloffice.travelofficespring.utils;

import altkom.groupwork.traveloffice.travelofficespring.model.*;
import altkom.groupwork.traveloffice.travelofficespring.model.Date;
import com.github.javafaker.Faker;

import java.util.*;

public class FakeDatabaseCreator {
     Set<Customer> customers;
     Map<String, Trip> trips;

    public FakeDatabaseCreator() {
        customers = new HashSet<>();
        trips = new HashMap<>();
        createCustomerHashSet();
        createTripHashMap();
        assignTrips();
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }

    public void createCustomerHashSet(){
        for(int i=0;i<10; i++){
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String streetAddress = faker.address().streetAddress();
            String zipCode = faker.address().zipCode();
            String city = faker.address().city();
            Address fullAddress = new Address (streetAddress,zipCode,city);
            Customer customer = new Customer(name);
            customer.setAddress(fullAddress);
            customers.add(customer);
        }
    }

    public void createTripHashMap(){
        String[] destination = {"Lodz","Poznan"};
        Date startDate = Date.createDate("2019.01.22",".");
        Date endDate = Date.createDate("2019.02.22",".");
        for(int i=0;i<5; i++){
            Faker faker = new Faker();
            String tripName = "Trip number "+(i+1);
            double price = faker.number().randomDouble(2,50,400);
            price = Math.ceil(price);
            double additionalCosts = Math.ceil((0.1*price)+faker.number().numberBetween(50,300));
            price*=10;

            if(i<2){

                DomesticTrip domesticTrip = new DomesticTrip(startDate,endDate,destination[i],price,Math.ceil(additionalCosts*0.5));
                String abroadTripDestination = faker.address().country();
                trips.put(tripName,domesticTrip);
                continue;
            }
            String abroadDestination = faker.address().country()+" - "+faker.address().city();
            AbroadTrip abroadTrip = new AbroadTrip(startDate,endDate,abroadDestination,price,additionalCosts);

            trips.put(tripName,abroadTrip);
        }

    }

    public void assignTrips(){
        List<Trip> tripList = new ArrayList<Trip>(trips.values());
        for(Customer customer : customers){
            customer.assignTrip(tripList.get(new Random().nextInt(tripList.size())));
        }
    }
}
