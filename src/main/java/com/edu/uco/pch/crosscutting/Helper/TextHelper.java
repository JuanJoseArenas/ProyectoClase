package com.edu.uco.pch.crosscutting.Helper;

public final class TextHelper {
	public static final String EMPTY = "";
	
	private TextHelper() {
		super();
	}
	
	public static final boolean isNull(final String string) {
		return ObjectHelper.getObjectHelper().isNull(string);
	}
	
	public static final boolean isNullOrEmpty(final String string) {
		return isNull(string) || EMPTY.equals(applyTrim(string));
	}
	
	public static final String getDefaultValue(final String string, final String defaultValue) {
		return ObjectHelper.getObjectHelper().getDefaultValue(string, defaultValue);
	}
	
	public static final String getDefaultValue(final String string) {
		return getDefaultValue(string, EMPTY);
	}
	public static final String applyTrim(final String string) {
		return getDefaultValue(string).trim();
	}
	
	public static final boolean isNull(final Object obj) {
        return obj == null;
	}
	
	public static final boolean isNullOrEmpty(final Object obj) {
		return isNull(obj) || EMPTY.equals((obj));
	}
}
