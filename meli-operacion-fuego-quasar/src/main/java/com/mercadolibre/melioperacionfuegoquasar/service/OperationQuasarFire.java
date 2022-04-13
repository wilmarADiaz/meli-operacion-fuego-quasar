package com.mercadolibre.melioperacionfuegoquasar.service;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;

public interface OperationQuasarFire {
	public Response getPositionDistressCallFromShip(Payload payload);
	public Response getPositionDistressCallFromShip();
	public boolean saveDistressCallFromShip(Satellite satellite);
}
