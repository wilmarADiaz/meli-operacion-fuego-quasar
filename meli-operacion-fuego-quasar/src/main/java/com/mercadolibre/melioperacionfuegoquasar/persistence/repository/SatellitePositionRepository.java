package com.mercadolibre.melioperacionfuegoquasar.persistence.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mercadolibre.melioperacionfuegoquasar.persistence.entity.SatellitePositionEntity;

@Repository
public interface SatellitePositionRepository extends JpaRepository<SatellitePositionEntity, Serializable> {

}
