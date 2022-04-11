package com.mercadolibre.melioperacionfuegoquasar.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
	private float x;
	private float y;
}
