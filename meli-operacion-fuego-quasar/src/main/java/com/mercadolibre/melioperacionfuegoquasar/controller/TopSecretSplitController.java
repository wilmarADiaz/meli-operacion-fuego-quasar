package com.mercadolibre.melioperacionfuegoquasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.entities.SatelliteTopSecretSplit;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.PositionException;
import com.mercadolibre.melioperacionfuegoquasar.service.OperationQuasarFire;

@RestController
public class TopSecretSplitController {
	@Autowired
	private OperationQuasarFire operation;
	
	@Autowired
	private Gson gson;
	
	@PostMapping(value = "${meli.path.topsecret.split.post}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPositionMessagge(@PathVariable("satellite_name") String satelliteName, @RequestBody SatelliteTopSecretSplit request) {
		boolean isSave=operation.saveDistressCallFromShip(new Satellite(satelliteName, request.getDistance(), request.getMessage()));
		if(isSave) {
			return ResponseEntity.ok().body("{\"save\":\"OK\"}");
		}else {
			return ResponseEntity.ok().body("{\"save\":\"KO\"}");
		}
	}
	
	@GetMapping(value = "${meli.path.topsecret.split.get}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getLocationController() {
		Response response = null;
		try {
			response = operation.getPositionDistressCallFromShip();
			return ResponseEntity.ok().body(gson.toJson(response));
		} catch (MessageNotValidException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		} catch (PositionException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
		
		
	}
}
