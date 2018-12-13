package altkom.groupwork.traveloffice.travelofficespring.controller;

import altkom.groupwork.traveloffice.travelofficespring.repository.FakeDatabase;
import altkom.groupwork.traveloffice.travelofficespring.service.TravelOfficeService;
import altkom.groupwork.traveloffice.travelofficespring.utils.FakeDatabaseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelOfficeController {

    @Autowired
    TravelOfficeService travelOfficeService;

    @GetMapping("/customers")
    public String showAllCustomers(){
        return travelOfficeService.showAllCustomers();
    }

    @GetMapping("/trips")
    public String showAllTrips(){
        return travelOfficeService.showAllTrips();
    }

    @GetMapping("/assignments")
    public String showAllInfo(){
        return travelOfficeService.toString();
    }



}
