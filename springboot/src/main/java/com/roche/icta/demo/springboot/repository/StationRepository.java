package com.roche.icta.demo.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.roche.icta.demo.springboot.model.Station;
import com.roche.icta.demo.springboot.model.StationEvent;

public interface StationRepository extends JpaRepository<Station, String>, PagingAndSortingRepository<Station, String>{

	@Query(value = "SELECT * FROM Stations ORDER BY haltestellen_name;", nativeQuery = true)
	public Page<Station> findAllStations(Pageable page);
	
}
