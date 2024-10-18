package com.roche.icta.demo.springboot.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "Trains")
public class Train {

    @Id
    @Column(name = "fahrt_bezeichner")
    private String id;

    @Column(name = "linien_text")
    private String name;

    @Column(name = "betreiber_abk")
    private String operator;
}