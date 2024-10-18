package com.roche.icta.demo.springboot.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.roche.icta.demo.springboot.model.Station;
import com.roche.icta.demo.springboot.repository.StationRepository;

@Service
public class AllStationsInfoService {
	@Autowired
	private StationRepository stationrepository;
	
	public List<Station> getAllTrainInfo(Integer pageNo, Integer pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		Page<Station> stationOp = stationrepository.findAllStations(page);
		if (stationOp.isEmpty()) {
			throw new NoSuchElementException("Station does not exist");
		} else {
			return stationOp.getContent();
	}
}
}