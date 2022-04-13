package com.mercadolibre.melioperacionfuegoquasar.entities;

import java.util.List;


public class Payload {

	private List<Satellite> satellites = null;
	
	public Payload() {}
	
	public Payload(List<Satellite> satellites) {
		super();
		this.satellites = satellites;
	}

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}
	
}
