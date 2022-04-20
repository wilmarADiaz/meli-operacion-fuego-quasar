package com.mercadolibre.melioperacionfuegoquasar.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;

@Component
public class DecodeSatelliteMessage {
	@Value("${meli.message.exception}")
	private String exceptionMessage;
	
	public String getMessage(List<List<String>> messages) throws MessageNotValidException {
		String [] listFinal=null;
		int sizeArray =0;
		if(messages.get(0).size() <= messages.get(1).size() && messages.get(0).size() <= messages.get(2).size()) {
			sizeArray = messages.get(0).size();
			listFinal= messages.get(0).stream().toArray(String[]::new);
		}else if (messages.get(1).size() <= messages.get(0).size() && messages.get(1).size() <= messages.get(2).size()) {
			sizeArray = messages.get(1).size();
			listFinal= messages.get(1).stream().toArray(String[]::new);
		}else if (messages.get(2).size() <= messages.get(0).size() && messages.get(2).size() <= messages.get(1).size()) {
			sizeArray = messages.get(2).size();
			listFinal= messages.get(2).stream().toArray(String[]::new);
		}
		for (int j = 0; j < messages.size(); j++) {
			for(int i=(sizeArray-1); i>=0; i--) {
				if(listFinal[i].isEmpty() && !messages.get(j).get(i).isEmpty()) {
					listFinal[i] = messages.get(j).get(i);
				}
			}
		}
		
		if(!vaidateMessage(listFinal)) {
			throw new MessageNotValidException(exceptionMessage);
		}
		return String.join(" ", listFinal);
	}
	public boolean vaidateMessage(String [] array) {
		Boolean isValid = null;
		for (int i = 0; i < array.length && (Objects.isNull(isValid) || isValid) ; i++) {
			if(!array[i].isEmpty()) {
				isValid = true;
			}if(array[i].isEmpty() &&  isValid != null) {
				isValid = false;
			}
			
		}
		return isValid;
	}
	
	
}
