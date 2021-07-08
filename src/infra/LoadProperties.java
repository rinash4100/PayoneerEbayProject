package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class LoadProperties {

	private Properties properties=new Properties(); //Singleton

	public LoadProperties(){
		try {
			properties.load(new FileInputStream(
					new File("../PayoneerProject/resources/property.gitIgnore")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getDriver() {
		return properties.get("driver").toString().toLowerCase();
	}

	public String getUrl() {
		return properties.get("url").toString();
	}
}
