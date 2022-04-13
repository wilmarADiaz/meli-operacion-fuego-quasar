package com.mercadolibre.melioperacionfuegoquasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.entities.SatelliteTopSecretSplit;
import com.mercadolibre.melioperacionfuegoquasar.service.OperationQuasarFire;

@RestController
public class TopSecretSplitController {
	@Autowired
	private OperationQuasarFire operation;
	
	@PostMapping(value = "${meli.path.topsecret.split}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPositionMessagge(@RequestParam("satellite_name") String satelliteName, @RequestBody SatelliteTopSecretSplit request) {
		boolean isSave=operation.saveDistressCallFromShip(new Satellite(satelliteName, request.getDistance(), request.getMessage()));
		if(isSave) {
			return ResponseEntity.ok().body("{\"save\":\"OK\"}");
		}else {
			return ResponseEntity.ok().body("{\"save\":\"KO\"}");
		}
	}
	
	@GetMapping(value = "${meli.path.topsecret.split}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getLocationController() {
		return ResponseEntity.ok().body("");
		
	}
}
