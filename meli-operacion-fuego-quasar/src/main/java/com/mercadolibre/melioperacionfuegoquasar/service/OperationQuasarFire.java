package com.mercadolibre.melioperacionfuegoquasar.service;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.PositionException;

public interface OperationQuasarFire {
	/**
	 * A partir del Payload que contiene la distancia y el mensaje recibido por cada satelite
	 * se determina la posición y el mensaje del la nave.
	 * @param payload informacion de los tres satelites kenobi, skywalker y sato
	 * @return Response la informacion de la nave pidiendo auxilio.
	 * @throws MessageNotValidException es lanzado cuando el mensaje no se pude determinar
	 * @throws PositionException es lanzado cuando la posicion no se pude determinar
	 */
	public Response getPositionDistressCallFromShip(Payload payload) throws MessageNotValidException, PositionException;
	
	/**
	 * A partir de la información almacenada en la base de datos, que contiene la distancia y el mensaje recibido por cada satelite
	 * se determina la posición y el mensaje del la nave que pide auxilio.
	 * @return Response la informacion de la nave pidiendo auxilio.
	 * @throws MessageNotValidException es lanzado cuando el mensaje no se pude determinar
	 * @throws PositionException es lanzado cuando la posicion no se pude determinar
	 */
	public Response getPositionDistressCallFromShip() throws MessageNotValidException, PositionException;
	
	/**
	 * Se va almacenando la informacion (distancia y mensaje) de los satelites en base de datos. 
	 * @param satellite contiene la información capturada por el satelite
	 * @return boolean si almacenó extitosamente o no
	 */
	public boolean saveDistressCallFromShip(Satellite satellite);
}
