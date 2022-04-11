package com.mercadolibre.melioperacionfuegoquasar.entities;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payload {

	private List<Satellite> satellites = null;

}
