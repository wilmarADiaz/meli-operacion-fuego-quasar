package com.mercadolibre.melioperacionfuegoquasar.entities;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Satellite {

	private String name;
	private float distance;
	private List<String> message = null;
}