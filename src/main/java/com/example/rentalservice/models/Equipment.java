package com.example.rentalservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Size(min = 1, max = 100)
    String name;
    @Size(min = 1, max = 30)
    String make;

    public Equipment(int id, String name, String make) {
        this.id = id;
        this.name = name;
        this.make = make;
    }

    public Equipment() {}
}