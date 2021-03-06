package com.mercadolibre.melioperacionfuegoquasar.entities;

/**
 * 
 * @author wilmar
 *	
 * Clase que contiene la posicion y el mensaje de la nave que pide auxilio.
 */
public class Response {
	private Position position;
	private String message;
	
	public Response() {}
	
	public Response(Position position, String message) {
		super();
		this.position = position;
		this.message = message;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
	
}
