package com.roche.icta.demo.springboot.repository;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.roche.icta.demo.springboot.model.Station;
import com.roche.icta.demo.springboot.model.StationEvent;

public interface StationEventRepository extends JpaRepository<StationEvent, Object>, PagingAndSortingRepository<StationEvent, Object> {
	@Query(value = " SELECT * FROM StationEvents e WHERE e.train_id = ?1 ORDER BY e.ankunftszeit, e.abfahrtszeit", nativeQuery = true)
	public List<StationEvent> findByTrainId(String train_id);
	
	@Query(value = " SELECT * FROM StationEvents e WHERE e.station_id = ?1 ORDER BY e.ankunftszeit, e.abfahrtszeit ", nativeQuery = true)
	public List<StationEvent> findByStationId(String station_id);

}
