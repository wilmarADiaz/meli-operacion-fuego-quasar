package com.mercadolibre.melioperacionfuegoquasar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Position;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatelliteMessageEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatellitePositionEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatelliteMessageRepository;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatellitePositionRepository;

@Service
public class OperationQuasarFireImpl implements OperationQuasarFire{
	@Resource
	private SatelliteMessageRepository messageRepository;
	
	@Resource
	private SatellitePositionRepository positionRepository;
	
	
	@Override
	public Response getPositionDistressCallFromShip(Payload payload) {
		
		List<SatellitePositionEntity> listEntity = positionRepository.findAll();
		listEntity.sort(Comparator.comparing(SatellitePositionEntity::getName));
		
		List<Satellite> list = payload.getSatellites();
		list.sort(Comparator.comparing(Satellite::getName));
		
		CalculatePositionSatellite calculateObj = new CalculatePositionSatellite(
				listEntity.get(0).getX(),listEntity.get(0).getY(),
				listEntity.get(2).getX(), listEntity.get(2).getY(),
				listEntity.get(1).getX(), listEntity.get(1).getY());
		Position position = calculateObj.getLocation(
					list.get(0).getDistance(), 
					list.get(2).getDistance(),
					list.get(1).getDistance());
		return new Response(position,"");
	}

	@Override
	public Response getPositionDistressCallFromShip() {
		List<SatellitePositionEntity> listEntity = positionRepository.findAll();
		listEntity.sort(Comparator.comparing(SatellitePositionEntity::getName));
		
		List<SatelliteMessageEntity> list = messageRepository.findAll();
		list.sort(Comparator.comparing(SatelliteMessageEntity::getName));
		
		CalculatePositionSatellite calculateObj = new CalculatePositionSatellite(
				listEntity.get(0).getX(),listEntity.get(0).getY(),
				listEntity.get(2).getX(), listEntity.get(2).getY(),
				listEntity.get(1).getX(), listEntity.get(1).getY());
		Position position = calculateObj.getLocation(
					list.get(0).getDistance(), 
					list.get(2).getDistance(),
					list.get(1).getDistance());
		
		return new Response(position,"");
	}

	@Override
	public boolean saveDistressCallFromShip(Satellite satellite) {
		SatelliteMessageEntity entity= messageRepository.findByName(satellite.getName());
		if(entity !=null && entity.getId() !=0) {
			entity.setDistance(satellite.getDistance());
			entity.setMessage(ListToString(satellite.getMessage()));
			entity = messageRepository.save(entity);
		}else {
			entity = messageRepository.save(new SatelliteMessageEntity(0,satellite.getName(), satellite.getDistance(), ListToString(satellite.getMessage())));
		}
		if(entity != null && entity.getId() !=0) {
			return true;
		}else {
			return false;
		}
			
		
		
	}
	
	public String ListToString(List<String> list) {
		return  String.join(",", list);
	}
	
	public List<String> StringToList(String str){
		return new ArrayList<String>(Arrays.asList(str.split(",")));
	}

	
		

}
