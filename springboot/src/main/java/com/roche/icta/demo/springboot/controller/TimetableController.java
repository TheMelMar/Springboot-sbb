package com.roche.icta.demo.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roche.icta.demo.springboot.model.Station;
import com.roche.icta.demo.springboot.model.Train;
import com.roche.icta.demo.springboot.model.dto.StationInfo;
import com.roche.icta.demo.springboot.model.dto.TrainInfo;
import com.roche.icta.demo.springboot.model.dto.AllStationInfo;
import com.roche.icta.demo.springboot.model.dto.AllTrainInfo;
import com.roche.icta.demo.springboot.repository.StationEventRepository;
import com.roche.icta.demo.springboot.repository.StationRepository;
import com.roche.icta.demo.springboot.repository.TrainRepository;
import com.roche.icta.demo.springboot.service.AllTrainInfoService;
import com.roche.icta.demo.springboot.service.StationInfoService;
import com.roche.icta.demo.springboot.service.TrainInfoService;

@Controller
@RequestMapping("")
public class TimetableController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TimetableController.class);

	@Autowired
	private TrainInfoService traininfoservice;
	
	@Autowired
	private AllTrainInfoService alltraininfoservice;
	
	@Autowired
	private StationInfoService stationinfoservice;
	
	@Autowired
	private StationEventRepository stationEventRepository;
	
	@Autowired
	private StationRepository stationRepository;
	@Autowired
	private TrainRepository trainRepository;

	@GetMapping("/trainInfo")
	public String viewTrainInfoPage(Model model, @RequestParam String id) {
		TrainInfo trainInfo = traininfoservice.getTrainInfo(id);
		model.addAttribute("trainInfo", trainInfo);
		return "trainInfo";
	}
	@GetMapping("/stationInfo")
	public String viewStationInfoPage(Model model, @RequestParam String id) {
		StationInfo stationInfo = stationinfoservice.getStationInfo(id);
		model.addAttribute("stationInfo", stationInfo);
		return "stationInfo";
	}
	@GetMapping("/SBB/homepage")
    public String viewTrainInfoPageMain(Model model) {
        return "SBB";
    }
	
	
	@GetMapping("/SBB/homepage/stations")
	public String viewStations(Model model, Pageable page, @RequestParam(defaultValue = "") String txtSearch) {
	    LOG.info("my search term was: {}", txtSearch);
	    LOG.error("the pageNo is {}, the pageSize is {}", page.getPageNumber(), page.getPageSize());
	    
	    // Assuming you have a repository method that fetches all stations
	    Page<Station> allStationInfo = stationRepository.findAllStations(page);
	    model.addAttribute("stationInfo", allStationInfo); // Use "stationInfo" as the attribute name
	    
	    return "allStations"; // This should match your Thymeleaf template name
	}

	@GetMapping("/SBB/homepage/trains")
	public String viewTrains(Model model, Pageable page, @RequestParam(defaultValue = "") String txtSearch) {
	    LOG.info("My search term was: {}", txtSearch);
	    LOG.error("The pageNo is {}, the pageSize is {}", page.getPageNumber(), page.getPageSize());

	    // Call the repository method with pagination
	    Page<Train> allTrainInfo = trainRepository.findAllTrains(page);
	    
	    // Add the paginated result to the model
	    model.addAttribute("allTrainInfo", allTrainInfo);
	    return "allTrains";
	}
}
	/*@GetMapping("/trainInfo")
		public String viewTrainID(Model model) {
		StationInfo trainInfo = stationsinfoservice.getStationInfo(8500010);
		model.addAttribute("trainInfo", trainInfo);
		return "";*/

	/*@GetMapping("/SBB")
	public String viewStationsInfoPage(Model model, @RequestParam String id) {
		StationInfo SBB = stationsinfoservice.getStationInfo(id);
		model.addAttribute("SBB", SBB);
		return "SBB";
	}*/
