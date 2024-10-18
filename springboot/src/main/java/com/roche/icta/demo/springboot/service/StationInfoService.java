package com.roche.icta.demo.springboot.service;



import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.roche.icta.demo.springboot.model.Station;
import com.roche.icta.demo.springboot.model.StationEvent;
import com.roche.icta.demo.springboot.model.dto.StationInfo;
import com.roche.icta.demo.springboot.model.dto.TrainInfo;
import com.roche.icta.demo.springboot.repository.StationEventRepository;
import com.roche.icta.demo.springboot.repository.StationRepository;

@Service
public class StationInfoService {
	
	@Autowired
	private StationRepository stationrepository;
	
	@Autowired
	private StationEventRepository stationeventrepository;

	public StationInfo getStationInfo(String stationId) {
		Optional<Station> stationOp = stationrepository.findById(stationId);
		List<StationEvent> stationeventOp = stationeventrepository.findByStationId(stationId);
		if (stationOp.isEmpty()) {
			throw new NoSuchElementException("Station with id" + stationId + "Does not exist");
		} else {
			StationInfo stationinfo = new StationInfo();
			stationinfo.setStation(stationOp.get());
			stationinfo.setStationevent(stationeventOp);
			//TODO; add station events for train
			return stationinfo;
		}
		
	}
	
	

}
