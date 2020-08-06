package com.example.rentalservice.repositories;

//import java.util.Optional;

import com.example.rentalservice.models.Rental;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer> {

  //  @Query("SELECT r.id, r.startDate, r.cost, r.status, c.name, e.make, e.name from Rental r LEFT OUTER JOIN Customer c ON c.id = r.customerId LEFT OUTER JOIN Equipment e on e.id = r.equipmentId where r.id = ?1")
 // public Optional<Object> getRentalDetails(int id);

}