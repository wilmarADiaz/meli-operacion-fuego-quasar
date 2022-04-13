package com.mercadolibre.melioperacionfuegoquasar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mercadolibre.melioperacionfuegoquasar.entities.Payload;
import com.mercadolibre.melioperacionfuegoquasar.entities.Response;
import com.mercadolibre.melioperacionfuegoquasar.entities.Satellite;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatelliteMessageEntity;
import com.mercadolibre.melioperacionfuegoquasar.persistence.repository.SatelliteMessageRepository;

@Service
public class OperationQuasarFireImpl implements OperationQuasarFire{
	@Resource
	private SatelliteMessageRepository repository;
	
	@Override
	public Response getPositionDistressCallFromShip(Payload payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getPositionDistressCallFromShip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveDistressCallFromShip(Satellite satellite) {
		SatelliteMessageEntity entity = repository.save(new SatelliteMessageEntity(0,satellite.getName(), satellite.getDistance(), ListToString(satellite.getMessage())));
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
