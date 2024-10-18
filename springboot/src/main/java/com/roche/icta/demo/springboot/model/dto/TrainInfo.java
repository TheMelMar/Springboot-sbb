package com.roche.icta.demo.springboot.model.dto;

import java.util.List;

import com.roche.icta.demo.springboot.model.StationEvent;
import com.roche.icta.demo.springboot.model.Train;

import lombok.Data;

@Data
public class TrainInfo {
	private Train train;
	private List<StationEvent> stationevent;
}
