package com.mercadolibre.melioperacionfuegoquasar.service;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.PositionException;

public interface OperationQuasarFire {
	public Response getPositionDistressCallFromShip(Payload payload) throws MessageNotValidException, PositionException;
	public Response getPositionDistressCallFromShip() throws MessageNotValidException, PositionException;
	public boolean saveDistressCallFromShip(Satellite satellite);
}
