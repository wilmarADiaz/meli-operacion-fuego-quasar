package com.mercadolibre.melioperacionfuegoquasar.persistence.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatelliteMessageEntity;


@Repository
public interface SatelliteMessageRepository extends JpaRepository<SatelliteMessageEntity, Serializable> {
	public SatelliteMessageEntity findByName(String name);
}
