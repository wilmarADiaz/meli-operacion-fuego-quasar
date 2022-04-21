package com.mercadolibre.melioperacionfuegoquasar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Position;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.MessageNotValidException;
import com.mercadolibre.melioperacionfuegoquasar.exceptions.PositionException;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatelliteMessageEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatellitePositionEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatelliteMessageRepository;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatellitePositionRepository;
import com.mercadolibre.melioperacionfuegoquasar.utils.Commons;

@Service
public class OperationQuasarFireImpl implements OperationQuasarFire{
	private final static Logger log = Logger.getLogger(OperationQuasarFireImpl.class.getName());
	
	@Resource
	private SatelliteMessageRepository messageRepository;
	
	@Resource
	private SatellitePositionRepository positionRepository;
	
	@Autowired
	private DecodeSatelliteMessage satelliteMessage;
	@Autowired
	private CalculatePositionSatellite calculateObj;
	
	
	@Override
	public Response getPositionDistressCallFromShip(Payload payload) throws MessageNotValidException, PositionException {
		log.log(Level.INFO, "init-getPositionDistressCallFromShip (payload)");		
		List<SatellitePositionEntity> listEntity = positionRepository.findAll();
		listEntity.sort(Comparator.comparing(SatellitePositionEntity::getName));
		
		List<Satellite> list = payload.getSatellites();
		list.sort(Comparator.comparing(Satellite::getName));
		calculateObj = new CalculatePositionSatellite();
		calculateObj.getPositionSatellite(
				listEntity.get(0).getX(),listEntity.get(0).getY(),
				listEntity.get(2).getX(), listEntity.get(2).getY(),
				listEntity.get(1).getX(), listEntity.get(1).getY());
		Position position = calculateObj.getLocation(
					list.get(0).getDistance(), 
					list.get(2).getDistance(),
					list.get(1).getDistance());
		
		satelliteMessage = new DecodeSatelliteMessage();
		List<List<String>> listMessages = new ArrayList<List<String>>();
		listMessages.add(payload.getSatellites().get(0).getMessage());
		listMessages.add(payload.getSatellites().get(1).getMessage());
		listMessages.add(payload.getSatellites().get(2).getMessage());
		
		String messageFinal = satelliteMessage.getMessage(listMessages);
		
		return new Response(position, messageFinal);
	}

	@Override
	public Response getPositionDistressCallFromShip() throws MessageNotValidException, PositionException {
		log.log(Level.INFO, "init-getPositionDistressCallFromShip");
		List<SatellitePositionEntity> listEntity = positionRepository.findAll();
		listEntity.sort(Comparator.comparing(SatellitePositionEntity::getName));
		
		List<SatelliteMessageEntity> list = messageRepository.findAll();
		list.sort(Comparator.comparing(SatelliteMessageEntity::getName));
		calculateObj = new CalculatePositionSatellite();
		calculateObj.getPositionSatellite(
				listEntity.get(0).getX(),listEntity.get(0).getY(),
				listEntity.get(2).getX(), listEntity.get(2).getY(),
				listEntity.get(1).getX(), listEntity.get(1).getY());
		Position position = calculateObj.getLocation(
					list.get(0).getDistance(), 
					list.get(2).getDistance(),
					list.get(1).getDistance());
		
		
		DecodeSatelliteMessage satelliteMessage = new DecodeSatelliteMessage();
		List<List<String>> listMessages = new ArrayList<List<String>>();
		listMessages.add(Commons.stringToList(list.get(0).getMessage()));
		listMessages.add(Commons.stringToList(list.get(1).getMessage()));
		listMessages.add(Commons.stringToList(list.get(2).getMessage()));
		
		String messageFinal = satelliteMessage.getMessage(listMessages);
		
		return new Response(position, messageFinal);
	}

	@Override
	public boolean saveDistressCallFromShip(Satellite satellite) {
		log.log(Level.INFO, "init-saveDistressCallFromShip");
		SatelliteMessageEntity entity= messageRepository.findByName(satellite.getName());
		if(entity !=null && entity.getId() !=0) {
			entity.setDistance(satellite.getDistance());
			entity.setMessage(Commons.listToString(satellite.getMessage()));
			entity = messageRepository.save(entity);
		}else {
			entity = messageRepository.save(new SatelliteMessageEntity(0,satellite.getName(), satellite.getDistance(), Commons.listToString(satellite.getMessage())));
		}
		if(Objects.isNull(entity)) {
			return false;
		}else {
			return true;
		}
			
		
		
	}
	
		

}
