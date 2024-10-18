package com.roche.icta.demo.springboot.model.dto;

import java.util.List;

import com.roche.icta.demo.springboot.model.Station;
import com.roche.icta.demo.springboot.model.StationEvent;

import lombok.Data;

@Data
public class StationInfo {
	private Station station;
	private List<StationEvent> stationevent;
}
