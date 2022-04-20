package com.mercadolibre.melioperacionfuegoquasar.exceptions;

public class MessageNotValidException extends Exception{	
	private static final long serialVersionUID = 1L;
	
	public MessageNotValidException(String message) {
		super(message);
	}

}
