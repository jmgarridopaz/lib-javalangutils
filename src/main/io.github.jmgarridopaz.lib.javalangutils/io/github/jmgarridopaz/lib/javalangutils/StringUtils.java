package io.github.jmgarridopaz.lib.javalangutils;


public final class StringUtils {

	private StringUtils() { }


	public static boolean isBlank ( String aString ) {
		return ( aString==null || aString.trim().isEmpty() );
	}

	
	public static boolean equalsIgnoreCaseTrimmed ( String aString, String anotherString ) {
		if ( (aString==null) && (anotherString==null) ) {
			return true;
		}
		if ( (aString==null) || (anotherString==null) ) {
			return false;
		}
		return aString.trim().equalsIgnoreCase ( anotherString.trim() );
	}

	
	public static boolean containsWhiteSpaces ( String aString ) {
		return ( (aString!=null) && (aString.indexOf(" ")>=0) );
	}
	
}
