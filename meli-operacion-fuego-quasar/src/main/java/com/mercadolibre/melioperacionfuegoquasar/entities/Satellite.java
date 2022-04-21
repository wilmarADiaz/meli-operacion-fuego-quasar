package com.mercadolibre.melioperacionfuegoquasar.entities;

import java.util.List;

/**
 * 
 * @author wilmar
 *	
 * Clase que contiene la informacion de nombre, distancia y mensaje del satelite
 * como llega del controller por /topsecret
 */
public class Satellite {

	private String name;
	private float distance;
	private List<String> message = null;
	
	public Satellite() {}
	
	public Satellite(String name, float distance, List<String> message) {
		super();
		this.name = name;
		this.distance = distance;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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