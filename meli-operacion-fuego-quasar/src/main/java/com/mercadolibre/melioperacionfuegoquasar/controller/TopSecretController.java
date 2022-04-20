package com.mercadolibre.melioperacionfuegoquasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.PositionException;
import com.mercadolibre.melioperacionfuegoquasar.service.OperationQuasarFire;

@RestController
public class TopSecretController {
	@Autowired
	private OperationQuasarFire operation;
	
	@Autowired
	private Gson gson;
	
	@PostMapping(value = "${meli.path.topsecret}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPositionMessage(@RequestBody Payload payload) {
		Response response = null;
		try {
			response = operation.getPositionDistressCallFromShip(payload);
			return ResponseEntity.ok().body(gson.toJson(response));
		} catch (MessageNotValidException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		} catch (PositionException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
		
	}
	
	
}
