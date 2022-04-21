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
 * Entity quye contiene o va contener la informacion de las posiciones de los satelites	
 */
@Entity
@Table(name = "satellite_position", schema = "quasar_operation_db")
public class SatellitePositionEntity implements Serializable{
	
	private static final long serialVersionUID = 1366768306416522551L;
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "x")
	private float x;
	@Column(name = "y")
	private float y;
	
	
	
	public SatellitePositionEntity() {}
	
	public SatellitePositionEntity(int id, String name, float x, float y) {
		super();
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	
	
	

}
