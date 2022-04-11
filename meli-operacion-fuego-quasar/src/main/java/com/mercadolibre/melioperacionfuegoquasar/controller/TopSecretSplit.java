package com.mercadolibre.melioperacionfuegoquasar.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;

@RestController
public class TopSecretSplit {
	@PostMapping(value = "/topsecret_split/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPositionMessagge(@RequestBody Payload payload) {
		return ResponseEntity.ok().body("");
	}
	
	@GetMapping(value = "/topsecret_split/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getLocationController() {
		return ResponseEntity.ok().body("");
		
	}
}
