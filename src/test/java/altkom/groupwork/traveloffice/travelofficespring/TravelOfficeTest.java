package altkom.groupwork.traveloffice.travelofficespring;

import altkom.groupwork.traveloffice.travelofficespring.model.*;
import altkom.groupwork.traveloffice.travelofficespring.service.TravelOfficeService;
import altkom.groupwork.traveloffice.travelofficespring.service.impl.TravelOfficeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class TravelOfficeTest {
    DomesticTrip domesticTrip;
    AbroadTrip abroadTrip;
    Set<Customer> customerSet;
    Map<String, Trip> tripMap;
    TravelOfficeService travelOfficeService;
    Date start;
    Date end;

    @Before
    public void init(){
        travelOfficeService = new TravelOfficeServiceImpl();
        customerSet = new HashSet<>();
        tripMap = new HashMap<>();
        start =  new Date(2018, 12, 15);
        end =  new Date(2020, 7, 25);


    }

    @Test
    public void shouldReturn2When2CustomersAdded() {
        //given
        Customer c1 = new Customer("name1");
        Customer c2 = new Customer("name2");
        //when
        customerSet.add(c1);
        customerSet.add(c2);
        //then
        assertEquals(2,customerSet.size());
    }

    @Test
    public void shouldReturnNullWhenCustomerGiven() {
        //given
        Customer c1 = new Customer("name1");
        customerSet.add(c1);
        //when
        customerSet.remove(c1);
        //then
        assertFalse(customerSet.contains(c1));
    }

    @Test
    public void shouldReturnCustomerWhenNameGiven() {
        //given
        String name = "C_NAME";
        Customer expected = new Customer(name);
        travelOfficeService.addCustomer(expected);
        //when
        Customer actual = travelOfficeService.findCustomerByName(name);
        //then
        assertEquals(expected.getName(),actual.getName());

    }

    @Test
    public void shouldReturnTrueWhenTripAdded() {
        //given
        domesticTrip = new DomesticTrip(start,end,"Destination1",1500,150);
        abroadTrip = new AbroadTrip(start,end,"Destination2",2000,100);
        //when
        tripMap.put("DOMESTIC_TRIP_1",domesticTrip);
        tripMap.put("ABROAD_TRIP_1",abroadTrip);
        //then
        assertEquals(2,tripMap.size());
        assertTrue(tripMap.containsValue(domesticTrip));
        assertTrue(tripMap.containsValue(abroadTrip));
    }

    @Test
    public void shouldReturnFalseWhenTripRemoved() {
        //given
        domesticTrip = new DomesticTrip(start,end,"Destination1",1500,150);
        abroadTrip = new AbroadTrip(start,end,"Destination2",2000,100);
        tripMap.put("DOMESTIC_TRIP_1",domesticTrip);
        tripMap.put("ABROAD_TRIP_1",abroadTrip);
        //when
        travelOfficeService.removeTrip("ABROAD_TRIP_1");
        //then
        assertFalse(tripMap.containsValue("ABROAD_TRIP_1"));
    }

    @Test
    public void shouldReturnTrueWhenCustomerSetAssigned() {
        //given
        Customer c1 = new Customer("name1");
        Customer c2 = new Customer("name2");
        customerSet.add(c1);
        customerSet.add(c2);
        //when
        HashSet<Customer> newSet = (HashSet<Customer>) customerSet;
        //then
        assertEquals(2,newSet.size());
        assertTrue(newSet.contains(c1));
        assertTrue(newSet.contains(c2));
    }

    @Test
    public void shouldReturnTrueWhenTripMapAssigned() {
        //given
        domesticTrip = new DomesticTrip(start,end,"Destination1",1500,150);
        abroadTrip = new AbroadTrip(start,end,"Destination2",2000,100);
        travelOfficeService.addTrip("DOMESTIC_TRIP_1",domesticTrip);
        travelOfficeService.addTrip("ABROAD_TRIP_1",abroadTrip);
        //when
        HashMap<String,Trip> newTripMap = (HashMap<String, Trip>) travelOfficeService.getAllTrips();
        //then
        assertTrue(newTripMap.containsKey("ABROAD_TRIP_1"));
        assertTrue(newTripMap.containsKey("DOMESTIC_TRIP_1"));

    }


}