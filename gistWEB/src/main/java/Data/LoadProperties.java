package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import Utilities.Log;

public class LoadProperties {

	// Load the properties file from the folder
	public static Properties userData = loadProperties(
			System.getProperty("user.dir") + "/src/main/java/Data/gistData.properties");

	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		// stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			Log.info("Error occurred1 :  " + e.getMessage());
		} catch (IOException e) {
			Log.info("Error occurred2 :  " + e.getMessage());
		} catch (NullPointerException e) {
			Log.info("Error occurred3 :  " + e.getMessage());
		}

		return pro;
	}

}
