package com.mercadolibre.melioperacionfuegoquasar.service;

import java.math.BigDecimal;

import com.mercadolibre.melioperacionfuegoquasar.entities.Position;

public class CalculatePositionSatellite {
	private float kenobiX;
	private float kenobiY;
	private float skywalkerX;
	private float skywalkerY;
	private float satoX;
	private float satoY;
	

	public CalculatePositionSatellite(float kenobiX, float kenobiY, float skywalkerX, float skywalkerY, float satoX,
			float satoY) {
		super();
		this.kenobiX = kenobiX;
		this.kenobiY = kenobiY;
		this.skywalkerX = skywalkerX;
		this.skywalkerY = skywalkerY;
		this.satoX = satoX;
		this.satoY = satoY;
	}







	public Position getLocation(final Float ...distances) {
		Position position = null;
		try {
			if (distances.length>2) {
				double a = -2 * kenobiX + 2 * skywalkerX;
				double b = -2 * kenobiY + 2 * skywalkerY;
				double c = Math.pow(distances[0], 2) - Math. pow(distances[1], 2) - Math.pow(kenobiX, 2) + Math.pow(skywalkerX, 2)  - Math.pow(kenobiY, 2)  + Math.pow(skywalkerY, 2) ;
			
				double e = -2 * skywalkerX + 2 * satoX;
				double f = -2 * skywalkerY + 2 * satoY;
				double g = Math.pow(distances[1], 2) - Math. pow(distances[2], 2) - Math.pow(skywalkerX, 2) + Math.pow(satoX, 2)  - Math.pow(skywalkerY, 2)  + Math.pow(satoY, 2) ;
				
				double d = a * f - b * e;
				if(d != 0.0) {
					double dx = c * f - b * g;
		            double dy = a * g - c * e;
		            float x = BigDecimal.valueOf(dx / d).setScale(2, java.math.RoundingMode.HALF_UP).floatValue();
		            float y = BigDecimal.valueOf(dy / d).setScale(2, java.math.RoundingMode.HALF_UP).floatValue();
		            position = new Position(x, y);
				}else{
					
				}
			}else{
				
			}
			return position;
		}catch (Exception e) {
			// TODO: handle exception
		}	
		
		return new Position();
	}
	
}
