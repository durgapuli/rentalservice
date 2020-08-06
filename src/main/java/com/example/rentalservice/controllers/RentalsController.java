package com.example.rentalservice.controllers;

import com.example.rentalservice.models.Rental;
import com.example.rentalservice.repositories.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/rentals")
public class RentalsController {

    // New ....
    @Autowired
    private RentalsRepository rentalsRepo;

    // Get all rentals (GET http://localhost/8080/rentals)
    @GetMapping(value = "")
    public @ResponseBody
    List<Rental> getAllRentals() {

        List<Rental> response = rentalsRepo.findAll();
        return response;
    } 

  // Get a specific rental by id
  @GetMapping(value="/{rentalId}")
  public @ResponseBody Rental getRentalById(@PathVariable int rentalId) throws Exception {

    Optional<Rental> response = rentalsRepo.findById(rentalId);
    //Optional<Object> response = rentalsRepo.getRentalDetails(rentalId);
    if(response.isEmpty()) {
      throw new Exception("Rental with id " + rentalId + " not found.");
    }
    return response.get();
  }

  // Create a new rental record
  @PostMapping(value="")
  public @ResponseBody String createRental(@RequestBody Rental rental) {
    // Clear the rental id and let the system generate the next id
    rental.setId(0);
    // Save to repository and database
    Rental newRental = rentalsRepo.save(rental);
    // Return the saved rental as a string
    return "Created a new rental:" + newRental.toString();
  }

  // Update existing rental record
  @PutMapping(value="/{rentalId}")
  public String updateRental(@PathVariable int rentalId, @RequestBody Rental rental) {

    // Check rental id in request body matches URI
    if (rental.getId() != rentalId) {
      throw new Error("Incorrect rental id.");
    }

    // Check if a matching record existins in the database
    Optional<Rental> dbRecord = rentalsRepo.findById(rentalId);
    if (dbRecord.isEmpty()) {
      throw new Error("Record does not exist for rental id " + rentalId);
    }

    // Update rental record
    Rental updatedRental = rentalsRepo.save(rental);
    return "Updated rental " + rentalId + " new info:" + updatedRental.toString();
  }


  // Delete rental record
  @DeleteMapping(value="/{rentalId}")
  public String deleteRental(@PathVariable int rentalId) {
    rentalsRepo.deleteById(rentalId);
    return "Deleted rental id " + rentalId ;
  }

}