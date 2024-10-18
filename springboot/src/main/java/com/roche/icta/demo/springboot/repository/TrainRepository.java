package com.roche.icta.demo.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.roche.icta.demo.springboot.model.Station;
import com.roche.icta.demo.springboot.model.Train;

public interface TrainRepository extends JpaRepository<Train, String> {

    @Query(value = "SELECT * FROM Trains ORDER BY fahrt_bezeichner",
           countQuery = "SELECT count(*) FROM Trains",
           nativeQuery = true)
    public Page<Train> findAllTrains(Pageable page);
}

