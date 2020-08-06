package com.example.rentalservice.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Size(min = 1, max = 20)
    String startDate;
    @Size(min = 1, max = 20)
    String endDate;
    int equipmentId;
    int customerId;
    double cost;
    char status;

    public Rental(int id, String startDate, String endDate,
                  int equipmentId, int customerId, double cost, char status) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.equipmentId = equipmentId;
        this.customerId = customerId;
        this.cost = cost;
        this.status = status;
    }

    public Rental () {}
}