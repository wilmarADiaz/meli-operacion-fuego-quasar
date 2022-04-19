package com.mercadolibre.melioperacionfuegoquasar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.google.gson.Gson;
import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatelliteMessageEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatellitePositionEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatelliteMessageRepository;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatellitePositionRepository;

@ExtendWith(MockitoExtension.class)
class OperationQuasarFireImplTest {
	@InjectMocks
	OperationQuasarFireImpl service;
	
	private Gson gson ;
	private Satellite satellite;
	private Payload payload;
	private Response response;
	private List<SatellitePositionEntity> listPosition;
	
	@Mock
	SatelliteMessageRepository repositoryMessage;
	
	@Mock
	SatellitePositionRepository repositoryPosition;
	
	@BeforeTestMethod
	void setUp() {
		gson = new Gson();
		String json = "{\n"
				+ "\"name\": \"kenobi\",\n"
				+ "\"distance\": 100.0,\n"
				+ "\"message\": [\"este\", \"\", \"\", \"mensaje\", \"\"]\n"
				+ "}";
		satellite = gson.fromJson(json, Satellite.class);
		
		String jsonPayload = "{\n"
				+ "    \"satellites\": [\n"
				+ "        {\n"
				+ "            \"name\": \"kenobi\",\n"
				+ "            \"distance\": 100,\n"
				+ "            \"message\": [\n"
				+ "                \"este\",\n"
				+ "                \"\",\n"
				+ "                \"\",\n"
				+ "                \"mensaje\",\n"
				+ "                \"\"\n"
				+ "            ]\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"name\": \"skywalker\",\n"
				+ "            \"distance\": 115.5,\n"
				+ "            \"message\": [\n"
				+ "                \"\",\n"
				+ "                \"es\",\n"
				+ "                \"\",\n"
				+ "                \"\",\n"
				+ "                \"secreto\"\n"
				+ "            ]\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"name\": \"sato\",\n"
				+ "            \"distance\": 142.7,\n"
				+ "            \"message\": [\n"
				+ "                \"este\",\n"
				+ "                \"\",\n"
				+ "                \"un\",\n"
				+ "                \"\",\n"
				+ "                \"\"\n"
				+ "            ]\n"
				+ "        }\n"
				+ "    ]\n"
				+ "}";
		payload = gson.fromJson(jsonPayload, Payload.class);
		/*
		String jsonResponse = "{\n"
				+ "\"position\": {\n"
				+ "\"x\": -100.0,\n"
				+ "\"y\": 75.5\n"
				+ "},\n"
				+ "\"message\": \"este es un mensaje secreto\"\n"
				+ "}";*/
		String jsonResponse = "{\n"
				+ "\"position\": {\n"
				+ "\"x\": -487.29,\n"
				+ "\"y\": 1557.01\n"
				+ "},\n"
				+ "\"message\": \"\"\n"
				+ "}";
		response = gson.fromJson(jsonResponse, Response.class);
		
		listPosition = new ArrayList<SatellitePositionEntity>();
		listPosition.add(new SatellitePositionEntity(1,"kenobi",-500,-200));
		listPosition.add(new SatellitePositionEntity(2,"skywalker",100, -100));
		listPosition.add(new SatellitePositionEntity(3,"sato",500, 100));
	}
	
	@Test
	void saveDistressCallFromShipTest() {
		setUp();
		Mockito.when(repositoryMessage.save(Mockito.any())).thenReturn(new SatelliteMessageEntity(1,"kenobi",100,"\"este\", \"\", \"\", \"mensaje\", \"\""));
		Mockito.when(repositoryMessage.findByName(Mockito.any())).thenReturn(null);
		assertEquals(true, service.saveDistressCallFromShip(satellite));
	}
	
	@Test
	void getPositionDistressCallFromShipTest() {
		setUp();				
		Mockito.when(repositoryPosition.findAll()).thenReturn(listPosition);
		assertEquals(response.getPosition().getX(), service.getPositionDistressCallFromShip(payload).getPosition().getX());
		assertEquals(response.getPosition().getY(), service.getPositionDistressCallFromShip(payload).getPosition().getY());
		assertEquals(response.getMessage(), service.getPositionDistressCallFromShip(payload).getMessage());
		
		
	}

}
