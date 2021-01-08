package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/*
	 * @method: initProperties
	 * 
	 * @param: null
	 * 
	 * @return property object
	 */
	public Properties initProperties() {
		prop = new Properties();
		try {
			// path is hard coded
			// we can replace with a constant
			FileInputStream ip = new FileInputStream("./src/test/resources/com/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
