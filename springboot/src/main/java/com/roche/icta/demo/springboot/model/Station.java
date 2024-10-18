package com.roche.icta.demo.springboot.model;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "Stations")  
public class Station {

    @Id
    @Column(name = "bpuic")  
    private String id;

    @Column(name = "haltestellen_name")  
    private String name;

    @Column(name = "departure_time")  // Assuming this is the correct column name
    private LocalDateTime departureTime;  // Adjust type based on your database column type
}



