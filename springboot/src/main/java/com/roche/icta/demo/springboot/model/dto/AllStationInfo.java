package com.roche.icta.demo.springboot.model.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.roche.icta.demo.springboot.model.Station;


import lombok.Data;


@Data
public class AllStationInfo {

	private Page<Station> station;

}
