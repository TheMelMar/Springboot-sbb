package com.roche.icta.demo.springboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.roche.icta.demo.springboot.model.dto.StationInfo;
import com.roche.icta.demo.springboot.service.StationInfoService;


@SpringBootTest(classes = MyDemoApplication.class)
public class StationInfoServiceTest {


		@Autowired
		private StationInfoService stationinfoservice;
		
		@Test
		void testGetStationInfo() {
			StationInfo stationinfo = stationinfoservice.getStationInfo("8500010");
			assertNotNull(stationinfo);
			System.out.println(stationinfo);
		}
		
	

}
