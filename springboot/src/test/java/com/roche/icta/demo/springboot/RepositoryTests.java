package com.roche.icta.demo.springboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.roche.icta.demo.springboot.model.Train;
import com.roche.icta.demo.springboot.repository.StationEventRepository;
import com.roche.icta.demo.springboot.repository.StationRepository;
import com.roche.icta.demo.springboot.repository.TrainRepository;

@SpringBootTest(classes = MyDemoApplication.class)
class RepositoryTests {
	
	@Autowired
	private TrainRepository trainRepository;

	@Autowired
	private StationRepository stationRepository;
	
	@Autowired
	private StationEventRepository stationeventrepository;
	
	@Test
	void repositoryTrainCheck() {

		Optional findTrain = trainRepository.findById("85:11:1070:001");
		assertNotNull(findTrain.get());
		
		Optional notFoundTrain = trainRepository.findById("9999");
		assertTrue(notFoundTrain.isEmpty());
		//log.info(findTrain.toString());
	}
	
	@Test
	void repositoryStationCheck() {
		Optional findStation = stationRepository.findById("8500010");
		assertNotNull(findStation.get());
		
		Optional notFoundStation = stationRepository.findById("007");
		assertTrue(notFoundStation.isEmpty());
	}

	@Test
	void repositoryStationEventCheck() {
		assertTrue(stationeventrepository.count() > 0);
	}

}
