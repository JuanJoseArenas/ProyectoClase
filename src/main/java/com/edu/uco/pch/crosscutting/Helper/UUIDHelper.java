package com.edu.uco.pch.crosscutting.Helper;

import java.util.Random;
import java.util.UUID;

public final class UUIDHelper {
	
	private static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";
	
	private UUIDHelper() {
		super();
	
	}
	
	public static UUID generarUUIDDefecto() {
        return new UUID(0L, 0L);
    }
	
	public static UUID convertirStringaUUID(String uuidString) {
            return UUID.fromString(uuidString);        
    }
	
	public static UUID generate() {
		Random random = new Random();
        long mas = random.nextLong();
        long menos = random.nextLong();
        return new UUID(mas, menos);
    }
	
	public static final UUID getDefault(final UUID value, final UUID valorDefecto) {		
		return ObjectHelper.getObjectHelper().getDefaultValue(value, valorDefecto);
	}
	
	
	public static final UUID getDefault() {
		return convertirStringaUUID(DEFAULT_UUID_STRING);
	}
}