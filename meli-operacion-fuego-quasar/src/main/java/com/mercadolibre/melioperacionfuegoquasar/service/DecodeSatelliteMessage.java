package com.mercadolibre.melioperacionfuegoquasar.service;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;

@Component
public class DecodeSatelliteMessage {
	private final static Logger log = Logger.getLogger(DecodeSatelliteMessage.class.getName());
	
	@Value("${meli.message.exception}")
	private String exceptionMessage;
	
	/**
	 * Se determina primero el mensaje que tenga menos posiciones como referencia,  
	 * debido a que el desfase es a la izquierda se empieza a completar el mensaje
	 * de la ultima palabla hacia la primera 
	 * 
	 * @param messages
	 * @return
	 * @throws MessageNotValidException
	 */
	public String getMessage(List<List<String>> messages) throws MessageNotValidException {
		log.log(Level.INFO, "init-getMessage");
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
			log.log(Level.SEVERE, exceptionMessage);
			throw new MessageNotValidException(exceptionMessage);
		}
		return String.join(" ", listFinal);
	}
	
	/**
	 * Valida si el mensaje fue completado o si por el contrario no se puede determinar
	 * @param array mensaje final
	 * @return boolean si es valido o no el mensaje
	 */
	public boolean vaidateMessage(String [] array) {
		log.log(Level.INFO, "init-vaidateMessage");
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
