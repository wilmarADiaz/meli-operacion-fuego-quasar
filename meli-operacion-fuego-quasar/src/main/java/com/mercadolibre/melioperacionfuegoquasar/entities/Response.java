package com.mercadolibre.melioperacionfuegoquasar.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
	private Position position;
	private String message;
}
