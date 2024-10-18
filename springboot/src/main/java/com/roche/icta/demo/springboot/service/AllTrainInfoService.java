package com.roche.icta.demo.springboot.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.roche.icta.demo.springboot.model.Train;
import com.roche.icta.demo.springboot.model.dto.AllTrainInfo;
import com.roche.icta.demo.springboot.model.dto.TrainInfo;
import com.roche.icta.demo.springboot.repository.TrainRepository;

@Service
public class AllTrainInfoService {

	@Autowired
	private TrainRepository trainrepository;
	
	public List<Train> getAllTrainInfo(Pageable page) {
		Page<Train> trainOp = trainrepository.findAllTrains(page);
		if (trainOp.isEmpty()) {
			throw new NoSuchElementException("Train does not exist");
		} else {
			return trainOp.getContent();
	}
}
}
