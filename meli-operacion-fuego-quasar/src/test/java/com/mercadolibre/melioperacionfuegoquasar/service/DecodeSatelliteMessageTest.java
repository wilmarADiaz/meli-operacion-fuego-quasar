package com.mercadolibre.melioperacionfuegoquasar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;
import com.mercadolibre.melioperacionfuegoquasar.utils.Commons;

public class DecodeSatelliteMessageTest {
	DecodeSatelliteMessage decodeMessage;
	List<List<String>> listMessage;
	List<List<String>> listMessageException;
	
	@BeforeTestMethod
	void setUp() {
		decodeMessage = new DecodeSatelliteMessage();
		listMessage = new ArrayList<List<String>>();
		List<String> listKenobi = Commons.stringToList("este,,,mensaje,");
		List<String> listSkywalker = Commons.stringToList(",es,,,secreto");
		List<String> listSato = Commons.stringToList("este,,un,,");
		listMessage.add(listKenobi);
		listMessage.add(listSkywalker);
		listMessage.add(listSato);
		
		listMessageException = new ArrayList<List<String>>();
		List<String> listKenobi2 = Commons.stringToList("este,,,mensaje,");
		List<String> listSkywalker2 = Commons.stringToList(",es,,,");
		List<String> listSato2 = Commons.stringToList("este,,un,,");
		listMessageException.add(listKenobi2);
		listMessageException.add(listSkywalker2);
		listMessageException.add(listSato2);
	}
	
	@Test
	void getMessageTest() {
		setUp();
		try {
			assertEquals("este es un mensaje secreto", decodeMessage.getMessage(listMessage));
		} catch (MessageNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	void getMessageExceptionTest() {
		setUp();
		assertThrows(MessageNotValidException.class, ()-> decodeMessage.getMessage(listMessageException));		
	}
}
