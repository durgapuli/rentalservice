package com.example.rentalservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(value = "/status")
    public String getStatus() {
        return "All Systems OK";
    }
}
