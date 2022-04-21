package com.mercadolibre.melioperacionfuegoquasar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commons {
	public static String listToString(List<String> list) {
		return  String.join(",", list);
	}
	
	public static List<String> stringToList(String str){
		return new ArrayList<String>(Arrays.asList(str.split("\\,",-1)));
	}
}
