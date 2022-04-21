package com.mercadolibre.melioperacionfuegoquasar.entities;

/**
 * 
 * @author wilmar
 * Clase que contiene la posicion de cada satelite.
 */
public class Position {
	private float x;
	private float y;
	
	public Position() {}
	
	public Position(float x, float y) {
		super();
		this.x = x;
		this.y = y;
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
