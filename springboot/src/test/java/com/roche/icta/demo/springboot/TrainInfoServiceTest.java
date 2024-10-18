package com.roche.icta.demo.springboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.roche.icta.demo.springboot.model.dto.TrainInfo;
import com.roche.icta.demo.springboot.service.TrainInfoService;

@SpringBootTest(classes = MyDemoApplication.class)
public class TrainInfoServiceTest {

	@Autowired
	private TrainInfoService traininfoservice;
	
	@Test
	void testGetTrainInfo() {
		TrainInfo traininfo = traininfoservice.getTrainInfo("85:11:1070:001");
		assertNotNull(traininfo);
		System.out.println(traininfo);
	}
	
}
