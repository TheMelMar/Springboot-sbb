package com.roche.icta.demo.springboot.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Embeddable
class StationEventKey{
	
	@OneToOne
	@JoinColumn(name = "train_id", referencedColumnName = "fahrt_bezeichner")
	private Train train;
	
	@OneToOne
	@JoinColumn(name = "station_id", referencedColumnName = "bpuic")
	private Station station;
	
}

@Data
@Table(name="StationEvents")
@Entity
public class StationEvent {
	
	@EmbeddedId
	private StationEventKey stationeventkey;

	@Column(name = "ankunftszeit")
	private Timestamp arrivalTime;

	@Column(name = "abfahrtszeit")
	private Timestamp departureTime;
	
	public Train getTrain() {
		return stationeventkey.getTrain();
	}
	public Station getStation() {
		return stationeventkey.getStation();
	}


}
