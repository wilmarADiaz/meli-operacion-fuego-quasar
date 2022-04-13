package com.mercadolibre.melioperacionfuegoquasar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.google.gson.Gson;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatelliteMessageEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatelliteMessageRepository;

@ExtendWith(MockitoExtension.class)
class OperationQuasarFireImplTest {
	@InjectMocks
	OperationQuasarFireImpl service;
	
	private Gson gson ;
	private Satellite satellite;
	
	@Mock
	SatelliteMessageRepository repository;
	
	@BeforeTestMethod
	void setUp() {
		gson = new Gson();
		String json = "{\n"
				+ "\"name\": \"kenobi\",\n"
				+ "\"distance\": 100.0,\n"
				+ "\"message\": [\"este\", \"\", \"\", \"mensaje\", \"\"]\n"
				+ "}";
		satellite = gson.fromJson(json, Satellite.class);
	}
	
	@Test
	void saveDistressCallFromShipTest() {
		setUp();
		Mockito.when(repository.save(Mockito.any())).thenReturn(new SatelliteMessageEntity(1,"kenobi",100,"\"este\", \"\", \"\", \"mensaje\", \"\""));
		assertEquals(true, service.saveDistressCallFromShip(satellite));
	}

}
