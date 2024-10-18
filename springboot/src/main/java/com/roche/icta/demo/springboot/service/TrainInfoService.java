package com.roche.icta.demo.springboot.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.roche.icta.demo.springboot.model.StationEvent;
import com.roche.icta.demo.springboot.model.Train;

import com.roche.icta.demo.springboot.model.dto.TrainInfo;
import com.roche.icta.demo.springboot.repository.StationEventRepository;
import com.roche.icta.demo.springboot.repository.TrainRepository;

@Service
public class TrainInfoService {

	@Autowired
	private TrainRepository trainrepository;
	
	@Autowired
	private StationEventRepository stationeventrepository;
	
	public TrainInfo getTrainInfo(String trainId) {
			Optional<Train> trainOp = trainrepository.findById(trainId);
			List<StationEvent> stationeventOp = stationeventrepository.findByTrainId(trainId);
			if (trainOp.isEmpty()) {
				throw new NoSuchElementException("Train with id" + trainId + "Does not exist");
			} else {
				TrainInfo traininfo = new TrainInfo();
				traininfo.setTrain(trainOp.get());
				traininfo.setStationevent(stationeventOp);
				//TODO; add station events for train
				return traininfo;
				
			}
		}
	}
	