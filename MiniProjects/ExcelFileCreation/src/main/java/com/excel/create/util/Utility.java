package com.excel.create.util;

import java.util.UUID;

public class Utility {

	public static String isUUIDEvenOrOdd(UUID uuid) {
		long lsb = uuid.getLeastSignificantBits();
		if( (lsb & 1) == 0 )
			return "Even";
		else
		 return "Odd";
	}
	
	public static UUID getUUID() {
		UUID uuid =  UUID.randomUUID();
		
		System.out.println("Is uuid even or odd : " + isUUIDEvenOrOdd(uuid));
		
		return uuid;
	}
}
