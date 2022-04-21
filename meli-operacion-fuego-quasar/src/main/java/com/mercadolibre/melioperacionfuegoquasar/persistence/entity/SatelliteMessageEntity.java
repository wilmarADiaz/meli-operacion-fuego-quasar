package com.mercadolibre.melioperacionfuegoquasar.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author wilmar
 *
 * Entity que contiene o va contener la informción de la tabla de mensaje, nombre y distancia
 */
@Entity
@Table(name = "satellite_message", schema = "quasar_operation_db")
public class SatelliteMessageEntity implements Serializable{
	private static final long serialVersionUID = -4272384108832362781L;
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "distance")
	private float distance;
	@Column(name = "message")
	private String message;
	
	public SatelliteMessageEntity() {}
	
	
	
	public SatelliteMessageEntity(int id, String satelliteName, float distance, String message) {
		super();
		this.id = id;
		this.name = satelliteName;
		this.distance = distance;
		this.message = message;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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



	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
