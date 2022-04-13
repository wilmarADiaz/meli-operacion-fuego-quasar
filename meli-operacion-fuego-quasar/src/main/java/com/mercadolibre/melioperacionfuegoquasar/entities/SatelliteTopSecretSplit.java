package com.mercadolibre.melioperacionfuegoquasar.entities;

import java.util.List;


public class SatelliteTopSecretSplit {	
	private float distance;
	private List<String> message = null;
	
	public SatelliteTopSecretSplit() {}
	
	public SatelliteTopSecretSplit(float distance, List<String> message) {
		super();
		this.distance = distance;
		this.message = message;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	
	
}
