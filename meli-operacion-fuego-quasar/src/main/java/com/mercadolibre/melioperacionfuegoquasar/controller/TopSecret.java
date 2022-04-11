package com.mercadolibre.melioperacionfuegoquasar.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;

@RestController
public class TopSecret {
	@PostMapping(value = "/topsecret/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPositionMessage(@RequestBody Payload payload) {
		return ResponseEntity.ok().body("");
	}
	
	
}
