package io.github.jmgarridopaz.lib.javalangutils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public final class FileUtils {

	private FileUtils() { }


	private static Properties propertiesFromFile ( Path propertiesFile ) {
		InputStream inputStream = null;
		try {
			inputStream = Files.newInputStream ( propertiesFile.toRealPath() );
			Properties properties = new Properties();
			properties.load(inputStream);
			return properties;
		} catch ( Exception e ) {
			throw new RuntimeException ( "Error loading properties from file '"+propertiesFile+"'", e);			
		} finally {
			if ( inputStream != null ) {
				try {
					inputStream.close();
				} catch (IOException ioe) {
					throw new RuntimeException ( "Error closing the file '"+propertiesFile+"'", ioe);			
				}
			}
		}
	}

	
	public static Optional<String> valueOfKeyFromPropertiesFile ( Path aPropertiesFile, String aKey ) {
		String value = propertiesFromFile(aPropertiesFile).getProperty(aKey);
		return Optional.ofNullable(value);
	}


	public static void writeToStandardOutput ( Path aFile ) {
		try
		( Stream<String> lines = Files.lines(aFile) )
		{
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            System.out.println(content);
        } catch (IOException ioe) {
			throw new RuntimeException ( "Error writing the file '"+aFile+"' to the standard output", ioe);			
        }
	}
	
}
