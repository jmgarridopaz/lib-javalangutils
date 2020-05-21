package io.github.jmgarridopaz.lib.javalangutils;

import java.util.Collection;


public final class CollectionUtils {
	
	private CollectionUtils() { }

	
	public static boolean isNullOrEmpty ( Collection<?> aCollection ) {
		return ( aCollection==null || aCollection.isEmpty() );
	}


	public static boolean hasAnyNullElement ( Collection<?> aCollection ) {
		if ( isNullOrEmpty(aCollection) ) {
			return false;
		}
		for ( Object element : aCollection ) {
			if ( element==null ) {
				return true;
			}
		}
		return false;
	}


	public static Object[] toArray ( Collection<?> aCollection )  {
		if ( isNullOrEmpty(aCollection) ) {
			return new Object[0];
		}
		return aCollection.stream().toArray(Object[]::new);		
	}

	
	public static boolean equals ( Collection<?> aCollection, Collection<?> anotherCollection ) {
        if ( aCollection==null && anotherCollection==null ) {
            return true;
        }
        if ( aCollection==null || anotherCollection==null ) {
            return false;
        }
        if ( aCollection.size() != anotherCollection.size() ) {
            return false;
        }
        return aCollection.containsAll ( anotherCollection );
    }
	
}
