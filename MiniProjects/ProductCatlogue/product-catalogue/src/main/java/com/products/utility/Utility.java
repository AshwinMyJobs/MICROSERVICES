package com.products.utility;

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
		return UUID.randomUUID();
	}
}
