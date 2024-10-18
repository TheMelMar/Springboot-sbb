package com.roche.icta.demo.springboot.model.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.roche.icta.demo.springboot.model.StationEvent;
import com.roche.icta.demo.springboot.model.Train;

import lombok.Data;

@Data
public class AllTrainInfo {
	private Page<Train> train;
}
